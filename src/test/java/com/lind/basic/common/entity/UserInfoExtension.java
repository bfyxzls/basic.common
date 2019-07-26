package com.lind.basic.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false) //不要比较父类的属性
public class UserInfoExtension extends BaseEntity {
  private String username;
}
