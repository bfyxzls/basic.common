package com.lind.basic.common.ddd.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件处理程序-发布邮件.
 */
@Component
public class EmailEventListener {

  /**
   * Handle an application event.
   *
   * @param event the event to respond to .
   */
  @EventListener
  public void onApplicationEventDelUserEvent(DelUserEvent event) {
    System.out.println("电子邮件的事件del:" + event.getMsg());

  }

  /**
   * Handle an application event.
   *
   * @param event the event to respond to .
   */
  @EventListener
  public void onApplicationEventRegisterUserEvent(RegisterUserEvent event) {
    System.out.println("电子邮件的事件register:" + event.getMsg());

  }
}