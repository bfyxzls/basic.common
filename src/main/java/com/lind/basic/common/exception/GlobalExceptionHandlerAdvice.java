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

/**
 * 全局异常拦截器.
 * 具体项目在使用时应该使用@ComponentScan("com.lind.basic.common")来开启它.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
  static final String SERVER_ERROR_MSG = "服务器处理失败";
  static final String PARAM_ERROR_MSG = "参数问题";
  static final String METHOD_PARAM_ERROR_MSG = "方法参数不合法";
  static final String UPLOAD_ERROR_MSG = "文件上传问题";

  /**
   * 服务端异常MissingServletRequestParameterException.
   *
   * @param ex .
   * @return
   */
  @ExceptionHandler(value = {MissingServletRequestParameterException.class})
  public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException ex) {
    log.error("missing servlet request parameter exception:{}", ex);
    return ResponseResult.fail(HttpStatus.BAD_REQUEST, PARAM_ERROR_MSG, ex.getStackTrace());
  }

  /**
   * 服务端异常MultipartException.
   *
   * @param ex .
   * @return
   */
  @ExceptionHandler(value = {MultipartException.class})
  public ResponseEntity<?> uploadFileLimitException(MultipartException ex) {
    log.error("upload file size limit:{}", ex);
    return ResponseResult.fail(HttpStatus.BAD_REQUEST, UPLOAD_ERROR_MSG, ex.getStackTrace());
  }

  /**
   * 服务端异常MethodArgumentNotValidException.
   *
   * @param ex .
   * @return
   */
  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  public ResponseEntity<?> serviceException(MethodArgumentNotValidException ex) {
    log.error("service exception:{}", ex);
    return ResponseResult.fail(HttpStatus.BAD_REQUEST, METHOD_PARAM_ERROR_MSG, ex.getStackTrace());
  }

  /**
   * 服务端异常Exception.
   *
   * @param ex .
   * @return
   */
  @ExceptionHandler(value = {Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<?> exception(Exception ex) {
    log.error("exception:{}", ex);
    return ResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR, SERVER_ERROR_MSG, ex.getStackTrace());
  }

  /**
   * 服务端异常Throwable.
   *
   * @param ex .
   * @return
   */
  @ExceptionHandler(value = {Throwable.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<?> throwable(Throwable ex) {
    log.error("Throwable:{}", ex);
    return ResponseResult.fail(HttpStatus.INTERNAL_SERVER_ERROR, SERVER_ERROR_MSG, ex.getStackTrace());
  }

  /**
   * 手动抛出的业务异常.
   *
   * @param httpStatusException .
   * @return
   */
  @ExceptionHandler(value = {HttpStatusException.class})
  public ResponseEntity<?> httpStatusException(HttpStatusException httpStatusException) {
    log.error("httpStatusException.status {},message {}",
        httpStatusException.getHttpStatus(), httpStatusException.getMessage());
    return ResponseResult.fail(
        httpStatusException.getHttpStatus(),
        httpStatusException.getMessage(), null);
  }
}
