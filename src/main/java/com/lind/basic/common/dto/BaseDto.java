package com.lind.basic.common.dto;

import java.util.function.Consumer;
import org.springframework.beans.BeanUtils;

/**
 * 数据传递对象基本类.
 */
public abstract class BaseDto {
  /**
   * 将dto类型转换为一个entity类型.
   *
   * @param clazz entity类型
   * @return
   */
  public <P> P toMapper(Class<P> clazz, Consumer<String> logger) {
    P p = null;
    try {
      p = clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      if (logger == null) {
        logger.accept("Param NewInstance Error");
      } else {
        logger.accept("Param NewInstance Error");
      }
    }
    BeanUtils.copyProperties(this, p);
    return p;
  }

  /**
   * 将dto类型转换为一个entity类型.
   *
   * @param clazz entity类型
   * @return
   */
  public <P> P toMapper(Class<P> clazz) {
    return toMapper(clazz, null);
  }
}
