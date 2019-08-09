package com.lind.basic.common.ddd.entity;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
  public final static String DEFAULT_USERNAME = "system";

  @Id
  @GeneratedValue
  private Long id;
  private String createdBy = DEFAULT_USERNAME;
  private String updatedBy = DEFAULT_USERNAME;
  private Instant createdTime;
  private Instant updatedTime;


  @PrePersist
  public void prePersist() {
    createdTime = updatedTime = Instant.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedTime = Instant.now();
  }
}
