package com.demo.portal.interceptor;

import com.demo.common.domain.ResponseCode;
import com.demo.common.domain.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestResponse methodTooManyResultsException(HttpServletRequest req, MethodArgumentNotValidException ex) {
        RestResponse result = RestResponse.exception(ResponseCode.SYS_REQUEST_PARAM_ILLEGAL);
        FieldError fe = ex.getBindingResult().getFieldError();
        String msg = fe.getDefaultMessage();
        log.info("---MethodArgumentNotValidException Handler--- ERROR: {}",msg);
        result.setMessage(msg);
        return result;
    }

}
