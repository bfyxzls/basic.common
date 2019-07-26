package com.lind.basic.common.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 数据传递对象基本类.
 */
@Slf4j
public class BaseDto {
  /**
   * 将dto类型转换为一个entity类型.
   *
   * @param clazz entity类型
   * @return
   */
  public <P> P toMapper(Class<P> clazz) {
    P p = null;
    try {
      p = clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      log.error("Param NewInstance Error");
    }
    BeanUtils.copyProperties(this, p);
    return p;
  }
}
