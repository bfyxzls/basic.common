package com.lind.basic.common.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;

/**
 * 将不可变的日期型变量，在静态构造中初以化，避免重复初始化浪费空间.
 */
public class Person {
  // The starting and ending dates of the baby boom
  private static final Date BOOM_START;
  private static final Date BOOM_END;
  // Other fields, methods, and constructor omitted

  static {
    Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));//格林威治时间
    gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
    BOOM_START = gmtCal.getTime();
    gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
    BOOM_END = gmtCal.getTime();
  }

  private Date birthDate;

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * 是否为生育高封期的人.
   *
   * @return
   */
  public boolean isBabyBoomer() {
    return birthDate.compareTo(BOOM_START) >= 0 &&
        birthDate.compareTo(BOOM_END) < 0;
  }

  @Test
  public void testBabyBoomer() {
    Person person = new Person();
    person.setBirthDate(BOOM_START);
    System.out.printf("isBabyBoomer %s", person.isBabyBoomer());
  }
}
