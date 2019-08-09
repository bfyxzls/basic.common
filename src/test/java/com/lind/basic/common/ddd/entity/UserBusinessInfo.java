package com.lind.basic.common.ddd.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 领域实体-用户业务行为.
 */
@Data
@EqualsAndHashCode(callSuper = false) //不要比较父类的属性
public class UserBusinessInfo extends BaseEntity {
  private String username;
  private Integer loginCount;
  private Integer sendViewCount;
  private Integer receiveViewCount;
  private Integer orderCount;
}
