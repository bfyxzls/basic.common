package com.lind.basic.common.ddd.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SmsEventListener {
  @EventListener
  public void handleOrderEvent(RegisterUserEvent event) {
    System.out.println("短信的事件:" + event.getMsg());
  }
}