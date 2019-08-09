package com.lind.basic.common.ddd.repository;

import com.lind.basic.common.ddd.entity.UserInfo;
import com.lind.basic.common.ddd.valueObject.Address;
import com.lind.basic.common.exception.HttpStatusException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试完成后，表和内容自动清除.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CurdTest {
  @Autowired
  UserInfoRepository userInfoRepository;

  /**
   * 异常测试.
   */
  @Test(expected = HttpStatusException.class)
  public void addError() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUsername("zzl");
    userInfo.setEmail("zzl@sina.com");
    userInfo.validate();
    userInfoRepository.save(userInfo);
  }

  /**
   * 正常测试.
   */
  @Test
  public void addOk() throws Exception {
    UserInfo userInfo = new UserInfo();
    Address address = new Address();
    address.setCity_code(10);
    address.setProvince_code(1);
    address.setDistrict_code(100);
    address.setDistrict_name("daxing");
    address.setCity_name("beijing");
    address.setProvince_name("beijing");
    userInfo.setUsername("zzl");
    userInfo.setEmail("zzl@sina.com");
    userInfo.setAddress(address);
    userInfo.validate();
    userInfoRepository.save(userInfo);
    System.out.println(userInfo.toString());
    userInfo.setUsername("xiugai");
    userInfoRepository.save(userInfo);
    UserInfo news = userInfoRepository.findById(userInfo.getId()).orElse(null);
    Assert.assertNotEquals(userInfo.getUpdatedTime(), news.getUpdatedTime());
  }
}
