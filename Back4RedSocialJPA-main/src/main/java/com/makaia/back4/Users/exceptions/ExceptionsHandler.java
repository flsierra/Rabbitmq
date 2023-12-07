package com.makaia.back4.Users.exceptions;

import com.makaia.back4.Comments.dtos.ResponseError;
import com.makaia.back4.Comments.exceptions.RedSocialApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = { com.makaia.back4.Comments.exceptions.RedSocialApiException.class })
    public ResponseEntity<ResponseError> handleRedSocialApiException(RedSocialApiException e) {
        ResponseError res = new ResponseError(e.getMessage(), e.getCode().value());

        return new ResponseEntity<ResponseError>(res, e.getCode());
    }
}
