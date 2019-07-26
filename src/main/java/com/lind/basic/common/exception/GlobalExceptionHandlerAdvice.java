package com.lind.basic.common.exception;

import com.lind.basic.common.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
  @ExceptionHandler(value = {MissingServletRequestParameterException.class})
  public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException ex) {
    log.error("missing servlet request parameter exception:{}", ex.getMessage());
    return ResponseResult.fail(HttpStatus.BAD_REQUEST, "参数问题", ex.getStackTrace());
  }

  @ExceptionHandler(value = {MultipartException.class})
  public ResponseEntity<?> uploadFileLimitException(MultipartException ex) {
    log.error("upload file size limit:{}", ex.getMessage());
    return ResponseResult.fail(HttpStatus.BAD_REQUEST, "文件上传问题", ex.getStackTrace());
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  public ResponseEntity<?> serviceException(MethodArgumentNotValidException ex) {
    log.error("service exception:{}", ex.getMessage());
    return ResponseResult.fail(HttpStatus.BAD_REQUEST, "方法参数不合法", ex.getStackTrace());
  }

  @ExceptionHandler(value = {Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<?> exception(Exception ex) {
    return ResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getStackTrace());
  }

  @ExceptionHandler(value = {Throwable.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<?> throwable(Throwable ex) {
    return ResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getStackTrace());
  }

  @ExceptionHandler(value = {HttpStatusException.class})
  public ResponseEntity<?> httpStatusException(HttpStatusException httpStatusException) {
    return ResponseResult.fail(httpStatusException.getHttpStatus(), httpStatusException.getMessage());
  }
}
