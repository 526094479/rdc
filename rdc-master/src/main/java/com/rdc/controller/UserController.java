package com.rdc.controller;

import com.rdc.entity.User;
import com.rdc.exception.DataTooLongException;
import com.rdc.service.UserService;
import com.rdc.util.GeetestConfig;
import com.rdc.util.GeetestLib;
import com.rdc.util.GsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    public String register(HttpSession session){
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());

        String resStr = "{}";

        //自定义userid
        String userid = "rdc";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);

        //将服务器状态设置到session中
        session.setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        session.setAttribute("userid", userid);

        resStr = gtSdk.getResponseStr();

        System.out.println(resStr);
        return resStr;
    }

    @ResponseBody
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(HttpSession session, User user,
                           String challenge, String validate, String seccode) throws DataTooLongException {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());

        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) session.getAttribute(gtSdk.gtServerStatusSessionKey);

        //从session中获取userid
        String userid = (String)session.getAttribute("userid");

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();

        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证
            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
            System.out.println(gtResult);
        } else {
            // gt-server非正常情况下，进行failback模式验证

            System.out.println("failback:use your own server captcha validate");
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
            System.out.println(gtResult);
        }

        if (gtResult == 1) {
            // 验证成功
            userService.saveUser(user);
            return GsonUtil.getSuccessJson("报名成功");
        }
        else {
            // 验证失败
            return GsonUtil.getErrorJson("请重新验证");
        }
    }
}
