package com.lind.basic.common.ddd.valueObject;


import javax.persistence.Embeddable;
import lombok.Data;

/**
 * 值对象-区域.
 */
@Embeddable
@Data
public class Address {
  private int city_code;
  private int province_code;
  private int district_code;
  private String city_name;
  private String province_name;
  private String district_name;
}