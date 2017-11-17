package com.titans.mobile.exception;
import org.springframework.http.HttpStatus;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.titans.mobile.utils.ResponseResult;
import com.titans.mobile.utils.ResultCode;

/**
 * Title: 全局的异常处理
 * Description:
 * @author liw
 * @created 2017年10月12日 下午4:56:44
 */
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult constraintViolationException(ConstraintViolationException ex) {
		 return new ResponseResult(ResultCode.EXCEPTION,ex.getMessage());
    }
    
    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult IllegalArgumentException(IllegalArgumentException ex) {
    	 return new ResponseResult(ResultCode.EXCEPTION,ex.getMessage());
    }
 
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult unknownException(Exception ex) {
    	 return new ResponseResult(ResultCode.EXCEPTION,ex.getMessage());
    }

}
