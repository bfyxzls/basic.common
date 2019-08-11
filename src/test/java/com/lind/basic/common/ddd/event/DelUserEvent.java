package com.lind.basic.common.ddd.event;

import lombok.Builder;
import lombok.Getter;

/**
 * 事件源-删除用户.
 */
@Builder(toBuilder = true)
@Getter
public class DelUserEvent {
  private Integer userId;
  private String msg;
}