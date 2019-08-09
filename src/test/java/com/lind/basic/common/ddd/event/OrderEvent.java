package com.lind.basic.common.ddd.event;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class OrderEvent {
  private String msg;
}