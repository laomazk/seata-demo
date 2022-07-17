package com.magic.common.exception;

import com.magic.common.RespBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author laoma
 * @create 2022-07-17 0:03
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RespBean runtimeExeception(RuntimeException e) {
        return RespBean.error(e.getMessage());
    }
}
