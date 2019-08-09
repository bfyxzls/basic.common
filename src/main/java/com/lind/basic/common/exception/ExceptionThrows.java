package com.lind.basic.common.exception;

/**
 * 业务层手动抛出异常的提供者.
 */
public class ExceptionThrows {

  /**
   * 客户端参数错误，请求400.
   */
  public static RuntimeException paramError(String msg) {
    return HttpStatusException.badRequest(msg);
  }

  /**
   * 系统错误 请求500.
   */
  public static RuntimeException internalServerError(String msg) {
    return HttpStatusException.internalServerError(msg);
  }

  /**
   * 没有权限，请求403.
   */
  public static RuntimeException forbidden(String msg) {
    return HttpStatusException.forbidden(msg);
  }

  /**
   * 没有授权，请求403.
   */
  public static RuntimeException unauthorized(String msg) {
    return HttpStatusException.unauthorized(msg);
  }

}
