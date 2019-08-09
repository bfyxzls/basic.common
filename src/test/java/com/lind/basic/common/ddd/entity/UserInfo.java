package com.lind.basic.common.ddd.entity;

import com.lind.basic.common.ddd.valueObject.Address;
import com.lind.basic.common.exception.ExceptionThrows;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * 领域实体-用户主体信息.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor()
@NoArgsConstructor
public class UserInfo extends BaseEntity {
  private String username;
  private String email;
  @Embedded
  private Address address;

  /**
   * 领域方法-校验.
   */
  public void validate() {
    if (getAddress() == null) {
      throw ExceptionThrows.paramError("address is not empty");
    }

    if (StringUtils.isBlank(getAddress().getProvince_name())) {
      throw ExceptionThrows.paramError("province is not empty");
    }

    if (StringUtils.isBlank(getAddress().getCity_name())) {
      throw ExceptionThrows.paramError("city is not empty");
    }
  }
}
