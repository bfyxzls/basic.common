package com.lind.basic.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 统一的响应.
 **/
@Getter
@ToString
public class ResponseResult<T> {

  static final String SUCCESSFUL_MSG = "处理成功";
  static final String FAIL_MSG = "服务器异常";

  /**
   * 是否成功.
   */
  private Boolean success;

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
  private T data;

  /**
   * 错误消息.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private ErrorModel error;

  /**
   * 内部使用，用于构造成功的结果.
   *
   * @param code
   * @param message
   * @param data
   */
  private ResponseResult(Boolean success, String code, String message, T data, ErrorModel error) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.data = data;
    this.timestamp = ZonedDateTime.now().toInstant();
    this.error = error;
  }

  /**
   * 快速创建成功结果.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<ResponseResult> success() {
    return success(null, SUCCESSFUL_MSG, null);
  }

  /**
   * 快速创建成功结果并返回结果数据.
   *
   * @param data
   * @return ResponseResult
   */
  public static ResponseEntity<ResponseResult> success(Object data) {
    return success(null, SUCCESSFUL_MSG, data);
  }

  /**
   * 快速创建成功结果.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<ResponseResult> success(String message) {
    return success(null, message, null);
  }

  /**
   * 快速创建成功结果.
   *
   * @return ResponseResult
   */
  public static ResponseEntity<ResponseResult> success(String code, String message, Object data) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseResult(true, code, message, data, null));
  }

  /**
   * 系统异常类并返回结果数据.
   *
   * @param data
   * @return ResponseResult
   */
  public static ResponseEntity<ResponseResult> fail(HttpStatus httpStatus, String message, Object data) {
    ErrorModel errorModel = null;
    if (data != null) {
      errorModel = ErrorModel.builder()
          .httpStatusCode(httpStatus.value())
          .message(message)
          .stack(data)
          .build();
    }
    return ResponseEntity.status(httpStatus)
        .body(new ResponseResult(false, null, message, null, errorModel));
  }

  @Getter
  @ToString
  @Builder(toBuilder = true)
  static class ErrorModel implements Serializable {
    private Integer httpStatusCode;
    private String message;
    private Object stack;
  }
}
