package com.rdc.service;

import com.rdc.dao.UserDao;
import com.rdc.entity.User;
import com.rdc.exception.DataTooLongException;
import com.rdc.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public String saveUser(User user) throws DataTooLongException {
        f(user.getName(),"姓名",20,false);
        f(user.getNumber(),"学号",10,false);
        f(user.getSex(),"性别",1,false);
        f(user.getMajorAndClass(),"学院专业班级",50,false);
        f(user.getPhone(),"手机号码",11,false);
        f(user.getOrganize(),"方向",3,false);
        f(user.getDuties(),"现任职务",30,true);
        f(user.getShortNumber(),"短号",30,true);
        f(user.getEmail(),"邮箱",50,true);
        f(user.getIntroduce(),"自我简介 ",500,true);
        f(user.getPurpose(),"期望",300,true);
        f(user.getSpeciality(),"特长 ",100,true);
        f(user.getQQ(),"QQ ",15,true);

        if (!testMatch("^3[1,2]17[0-9]{6}$", user.getNumber())) {
            return GsonUtil.getErrorJson("请输入正确的学号");
        }
        if (!testMatch("^1[0-9]{10}$", user.getPhone())) {
            return GsonUtil.getErrorJson("请输入正确的手机号码");
        }
        userDao.saveUser(user);
        return GsonUtil.getSuccessJson("注册成功");

    }

    private Boolean testMatch(String str1, String str2) {
        Pattern pattern1 = Pattern.compile(str1);
        Matcher matcher = pattern1.matcher(str2);
        return matcher.matches();
    }

    private void f(String origin, String desp, int max, boolean nullable) throws DataTooLongException {
        if (!nullable){
            Assert.notNull(origin, desp + "不能为空");
        }else {
            if(origin!=null&&origin.length() > max)
                throw new DataTooLongException(desp + "太长啦");
        }
    }

}
