package com.lind.basic.common.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.Data;

@Data
public abstract class BaseEntity implements Serializable {
  public final static String DEFAULT_USERNAME = "system";
  private Long id = 0L;
  private String createdBy = DEFAULT_USERNAME;
  private String updatedBy = DEFAULT_USERNAME;
  private Date createdTime = Date.from(ZonedDateTime.now().toInstant());
  private Date updatedTime = Date.from(ZonedDateTime.now().toInstant());
}
