package com.lind.basic.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.Instant;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 统一的响应.
 **/
@Getter
@ToString
public class ResponseResult {

  static final String SUCCESSFUL_MSG = "处理成功";
  static final String FAIL_MSG = "服务器异常";

  /**
   * 业务状态码，为null时不去序列化.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String code;
  /**
   * 消息.
   */
  private String message;
  /**
   * 时间戳.
   */
  private Instant timestamp;
  /**
   * 响应的数据，为null时不去序列化.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Object data;

  /**
   * 内部使用，用于构造成功的结果.
   *
   * @param code
   * @param mesg
   * @param data
   */
  private ResponseResult(String code, String mesg, Object data) {
    this.code = code;
    this.message = mesg;
    this.data = data;
    this.timestamp = ZonedDateTime.now().toInstant();
  }

  /**
   * 快速创建成功结果.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> success() {
    return success(null, SUCCESSFUL_MSG, null);
  }

  /**
   * 快速创建成功结果并返回结果数据.
   *
   * @param data
   * @return ResponseResult
   */
  public static ResponseEntity<?> success(Object data) {
    return success(null, SUCCESSFUL_MSG, data);
  }

  /**
   * 快速创建成功结果.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> success(String message) {
    return success(null, message, null);
  }

  /**
   * 快速创建成功结果.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> success(String code, String message, Object data) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseResult(code, message, data));
  }

  /**
   * 系统异常类没有返回数据.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> fail() {
    return fail(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * 系统异常类没有返回数据.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> fail(HttpStatus httpStatus) {
    return fail(httpStatus, null);
  }

  /**
   * 系统异常类并返回结果数据.
   *
   * @param data
   * @return ResponseResult
   */
  public static ResponseEntity<?> fail(HttpStatus httpStatus, Object data) {
    return fail(httpStatus, FAIL_MSG, data);
  }

  /**
   * 系统异常类并返回结果数据.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> fail(HttpStatus httpStatus, String message) {
    return fail(httpStatus, message, null);
  }

  /**
   * 系统异常类并返回结果数据.
   *
   * @param data
   * @return ResponseResult
   */
  public static ResponseEntity<?> fail(HttpStatus httpStatus, String message, Object data) {
    return ResponseEntity.status(httpStatus)
        .body(new ResponseResult(null, message, data));
  }


  /**
   * 参数错误.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> failBadParameter(String message) {
    return fail(HttpStatus.BAD_REQUEST, message, null);
  }

  /**
   * 没有授权.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> failUnauthorized(String message) {
    return fail(HttpStatus.UNAUTHORIZED, message, null);
  }

  /**
   * 没有访问的权限.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<?> failForbidden(String message) {
    return fail(HttpStatus.FORBIDDEN, message, null);
  }
}
