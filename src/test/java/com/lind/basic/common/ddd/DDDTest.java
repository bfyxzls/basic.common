package com.lind.basic.common.ddd;

import com.lind.basic.common.ddd.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DDDTest {
  @Test
  public void events() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername("zzl");
    userInfo.setEmail("abc@sina.com");
    userInfo.setId(1L);
    userInfo.registerUser();
  }
}
