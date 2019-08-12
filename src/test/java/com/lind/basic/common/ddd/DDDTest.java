package com.lind.basic.common.ddd;

import com.lind.basic.common.ddd.entity.UserInfo;
import com.lind.basic.common.ddd.service.UserService;
import com.lind.basic.common.ddd.valueObject.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DDDTest {
  @Autowired
  ApplicationEventPublisher applicationEventPublisher;
  @Autowired
  UserService userService;

  @Test
  public void events() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername("zzl");
    userInfo.setEmail("abc@sina.com");
    userInfo.setId(1L);
    userInfo.registerUserEvent(applicationEventPublisher);
  }

  @Test
  public void registerTest() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername("zzl");
    userInfo.setEmail("abc@sina.com");
    userInfo.setId(1L);
    userInfo.setAddress(Address.builder()
        .city_code(1)
        .city_name("beijing")
        .district_code(2)
        .district_name("daxing")
        .province_code(3)
        .province_name("beijing")
        .build());
    userService.register(userInfo);
  }
}
