package com.lind.basic.common.ddd.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件处理程序-发布邮件.
 */
@Component
public class EmailEventListener {
  @EventListener
  public void handleRegisterUserEvent(RegisterUserEvent event) {
    System.out.println("电子邮件的事件:" + event.getMsg());
  }

  @EventListener
  public void handleDelUserEvent(DelUserEvent event) {
    System.out.println("电子邮件的事件:" + event.getMsg());
  }
}