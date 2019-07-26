package com.lind.basic.common;

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
}
