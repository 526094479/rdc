package com.rdc.resolver;

import com.rdc.exception.DataTooLongException;
import com.rdc.util.GsonUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**rdc
 * 异常解析器，以Json形式返回 <code> {result:"error"; message:"xxx"} </code>
 * Created by ZJH on 2017/8/11.
 */

@ControllerAdvice
public class ExceptionResolver {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String handle(Exception e){
        e.printStackTrace();
        if (e instanceof NullPointerException){
            return GsonUtil.getErrorJson("NullPointerException");
        }
        return GsonUtil.getErrorJson(e.getMessage());
    }


}
