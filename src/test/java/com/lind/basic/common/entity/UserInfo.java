package com.lind.basic.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity {
  private String username;
}
