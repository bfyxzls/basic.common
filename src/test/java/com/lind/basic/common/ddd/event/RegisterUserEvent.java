package com.lind.basic.common.ddd.event;

import lombok.Builder;
import lombok.Getter;

/**
 * 事件源-注册用户.
 * @author zhangzhanling
 * @version 1.0
 * @see EmailEventListener#onApplicationEventRegisterUserEvent
 */
@Builder(toBuilder = true)
@Getter
public class RegisterUserEvent {
  private Long userId;
  private String msg;
}