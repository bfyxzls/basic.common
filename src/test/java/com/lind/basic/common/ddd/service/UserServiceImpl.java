package com.lind.basic.common.ddd.service;

import com.lind.basic.common.ddd.entity.UserInfo;
import com.lind.basic.common.ddd.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  ApplicationEventPublisher applicationEventPublisher;
  @Autowired
  UserInfoRepository userInfoRepository;

  @Override
  public void register(UserInfo userInfo) {
    userInfo.validate();
    userInfoRepository.save(userInfo);
    userInfo.registerUserEvent(applicationEventPublisher);
  }

  @Override
  public UserInfo get(Long id) {
    return userInfoRepository.getOne(id);
  }
}
