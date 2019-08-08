package com.lind.basic.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;

public class RedPackageUtilsTest {
  @Test
  public void mockSend() {
    ArrayList<BigDecimal> list = RedPackageUtils.send("zzl", 100, 80, 10);
    RedPackageUtils.receiver("zhz", list);
    RedPackageUtils.receiver("zql", list);
  }
}
