package com.lind.basic.common.util;

import org.junit.Test;

public class SnowflakeIdWorkerUtilsTest {
  @Test
  public void generateId() {
    for (int i = 0; i < 10; i++) {
      System.out.println(SnowflakeIdWorkerUtils.INSTANCE.nextId());
    }
  }
}
