package com.lind.basic.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 状态码异常，由业务层显示抛出.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpStatusException extends RuntimeException {

  /**
   * 状态码.
   */
  private final HttpStatus httpStatus;

  /**
   * 错误消息.
   */
  private final String message;

  /**
   * 创建RuntimeException.
   *
   * @param httpStatus httpStatus
   * @param message    message
   * @return {@link RuntimeException}
   */
  static RuntimeException of(HttpStatus httpStatus, String message) {
    return new HttpStatusException(httpStatus, message);
  }

  /**
   * bad Request.
   */
  static RuntimeException badRequest(String message) {
    return of(HttpStatus.BAD_REQUEST, message);
  }

  /**
   * unauthorized.
   */
  static RuntimeException unauthorized(String message) {
    return of(HttpStatus.UNAUTHORIZED, message);
  }

  /**
   * forbidden.
   */
  static RuntimeException forbidden(String message) {
    return of(HttpStatus.FORBIDDEN, message);
  }

  /**
   * internal Server Error.
   */
  static RuntimeException internalServerError(String message) {
    return of(HttpStatus.INTERNAL_SERVER_ERROR, message);
  }
}
