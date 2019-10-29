package basic.common.redis;

import org.junit.Assert;
import org.junit.Test;

public class RedisTest {

  @Test
  public void entityTest(){
    RedisEntity redisEntity=new RedisEntity();
    redisEntity.setId("001");
    redisEntity.setInformation("hello");
    Assert.assertEquals("001", redisEntity.getId());
  }
}
