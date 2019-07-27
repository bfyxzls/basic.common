package com.lind.basic.common;

import com.lind.basic.common.dto.CreateUserDto;
import com.lind.basic.common.dto.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

@Slf4j
public class DtoResponseResultTest {
  @Test
  public void successTest() {
    ResponseEntity responseResult = ResponseResult.success("请求成功");
    log.info("result:{}", responseResult);
  }

  @Test
  public void dtoResult() {
    ResponseResult<CreateUserDto> responseResult =
        ResponseResult.success(
            CreateUserDto.builder()
                .email("bfyxzls@qq.com")
                .username("test")
                .build()).getBody();

    log.info("responseResult {}", responseResult);
  }
}
