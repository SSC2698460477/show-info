package com.ssc.showinfo.common.exception;

import com.ssc.showinfo.common.response.ResultCode;

import java.text.MessageFormat;

/**
 * @program: show-info
 * @description: 自定义的错误类
 * @author: ssc
 * @create: 2019/10/8 22:27
 **/
public class CustomException extends RuntimeException{

    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public CustomException(ResultCode resultCode, Object... args){
        super(resultCode.message());
        String message = MessageFormat.format(resultCode.message(), args);
        resultCode.setMessage(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }

}
