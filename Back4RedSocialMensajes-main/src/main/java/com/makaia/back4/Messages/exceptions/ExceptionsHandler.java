package com.makaia.back4.Messages.exceptions;

import com.makaia.back4.Messages.dtos.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = { RedSocialApiException.class })
    public ResponseEntity<ResponseError> handleRedSocialApiException(RedSocialApiException e) {
        ResponseError res = new ResponseError(e.getMessage(), e.getCode().value());

        return new ResponseEntity<ResponseError>(res, e.getCode());
    }
}
