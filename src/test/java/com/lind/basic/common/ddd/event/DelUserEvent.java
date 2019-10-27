package com.lind.basic.common.ddd.event;

import lombok.Builder;
import lombok.Getter;

/**
 * 事件源-删除用户.
 * @author zhangzhanling
 * @version 1.0
 * @see EmailEventListener#onApplicationEventDelUserEvent
 */
@Builder(toBuilder = true)
@Getter
public class DelUserEvent {
  private Long userId;
  private String msg;
}