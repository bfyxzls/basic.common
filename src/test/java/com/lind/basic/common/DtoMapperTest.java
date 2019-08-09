package com.lind.basic.common;

import com.lind.basic.common.dto.CreateUserDto;
import com.lind.basic.common.ddd.entity.UserInfo;
import com.lind.basic.common.ddd.entity.UserBusinessInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class DtoMapperTest {
  @Test
  public void dtoToEntity() {
    CreateUserDto createUserDto = CreateUserDto.builder()
        .username("lind")
        .email("bfyxzls@sina.com")
        .build();
    log.info("userinfo:{}", createUserDto.toMapper(UserInfo.class));
  }

  @Test
  public void equalsAndHashCodeTrueTest() {
    UserInfo userInfo1 = new UserInfo();
    userInfo1.setId(1L);
    userInfo1.setUsername("lind");

    UserInfo userInfo2 = new UserInfo();
    userInfo2.setId(2L);
    userInfo2.setUsername("lind");

    Assert.assertNotEquals(userInfo1, userInfo2);
  }

  @Test
  public void equalsAndHashCodeFalseTest() {
    UserBusinessInfo userInfo1 = new UserBusinessInfo();
    userInfo1.setId(1L);
    userInfo1.setUsername("lind");

    UserBusinessInfo userInfo2 = new UserBusinessInfo();
    userInfo2.setId(2L);
    userInfo2.setUsername("lind");

    Assert.assertEquals(userInfo1, userInfo2);
  }
}