package com.lind.basic.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class RedPackageUtils {
  private RedPackageUtils() {
    throw new AssertionError();
  }

  /**
   * 分发红包思路.
   *
   * @param blanceMoney 用户余额
   * @param totalMoney  红包金额
   * @param count       红包数量
   * @return
   */
  public static ArrayList<BigDecimal> send(String username, double blanceMoney, double totalMoney, int count) {
    /*
     * 分发红包思路:
     *
     * 步骤1. 该分发红包的方法接受四个参数:用户username,余额blanceMoney,红包金额totalMoney,红包拆分的个数count
     *        如果红包金额存在小数,需要将小数位分离出来,分成整数部分 MoneyInt 和 小数部分 decimalPart.
     * 步骤2. 将总金额分成N个红包,那我们先包好N-1个红包,每个红包随机赋予(0,MoneyInt)之间的值
     * 步骤3. 然后用金额上限/红包总额 得到一个系数(保存了每个红包金额*系数小于红包总额).
     * 步骤4. 将每个红包的值 * 系数 = 每个红包的实际值
     *        红包1:1*0.666=0.666 红包2:2*0.666 = 1.333 红包3:3*0.666=1.999
     * 步骤5. 最后一个红包的值 = 总的红包金额 - 红包1-红包2-红包3 + 步骤一拆分的余数;
     *
     * 举例说明:假设totalMoney为10.5,分成3个包.先将10.5拆分成 10 和 0.5
     * 以10为基准,随机生成0-10的数字赋给红包1和2,比如红包1的值为4,红包2的值为8
     * 10/(4+8) = 0.8333
     * 0.5882*8=4.7056    0.5882*9=5.2938
     * 0.5263*9=4.7367          0.5263*9=4.7367
     * 红包1:4*0.8333=3.3333   红包2:8*0.8333=6.666
     * 那么红包3的值 = MoneyInt - 红包1 - 红包2 + decimalPart.|| 红包3=10-3.3333-6.666+0.5 =0.5007
     * */

    /*
     * 前一个arrayList类型为Double用来划分红包的金额
     * 后一个arrayDB用来精确计算,计算数据来源于arrayList的成员.保留两位小数.
     * 返回BigDecimal类型的集合对象.
     * */
    ArrayList<Double> arrayList = new ArrayList<>();
    ArrayList<BigDecimal> araryBD = new ArrayList<>();
    //首先看发红包的人有多少钱,钱不足直接提示/退出.钱够了就开始发红包.
    Double leftmoney = blanceMoney;
    if (totalMoney > leftmoney) {
      throw new IllegalArgumentException("对不起您的账户余额不足,请先充值!");
    } else {
      System.out.printf("用户名:[%s]的用户派发了[%.2f]元的红包!   \n", username, totalMoney);
    }
    //扣钱,本质就是重新对money属性进行改写
    blanceMoney = leftmoney - totalMoney;
    //发红包拆分成count份数,每份的金额不定
    //红包不一定是整数,如果有人非要发带小数的红包,那么我们将小数位分离出来.
    double decimalPart = totalMoney - (int) (totalMoney);
    //单独分理出小数,就可以直接处理整数部分了.赋给变量moneyInt
    int moneyInt = (int) (totalMoney);
    Random ra = new Random();
    double temp = 0, sumNum = 0;
        /*步骤2. 将总金额分成N个红包,那我们先包好N-1个红包,
        每个红包随机赋予(0,MoneyInt)之间的值*/
    for (int i = 0; i < count; i++) {
      temp = (double) ra.nextInt(moneyInt);
      arrayList.add(temp);
      sumNum += temp;
    }
    /* * 步骤3. 然后用金额上限/红包总额 得到一个系数.*/
    double xishu = moneyInt / sumNum;
    /*定义与系数运算后的接受变量numAfter/sumAfter */
    double numAfter = 0, sumAfter = 0;
    for (int i = 0; i < count - 1; i++) {
      /** 步骤4. 将每个红包的值 * 系数 = 每个红包的实际值*/
      numAfter = arrayList.get(i) * xishu;
      arrayList.set(i, numAfter);
      //将numAfter传递给BigDecimal类,需要将浮点数转换成字符串
      String str = numAfter + "";
      BigDecimal decimal = new BigDecimal(str);
      BigDecimal setScale1 = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
      //将decimal添加到BigDecimal类的集合中
      araryBD.add(setScale1);
      sumAfter += numAfter;
    }
    //初始化最后一个红包的值为0
    double finalNum = 0;
    /*步骤5. 最后一个红包的值 = 总的红包金额 - 红包1-红包2-红包3 + 步骤一拆分的余数;*/
    finalNum = (double) moneyInt - sumAfter + decimalPart;
    //  arrayList.set(count-1,finalNum);
    /*将最后一个红包的值转换为String类型的对象,然后传递给BigDecimal
     * 用过setScale();方法将结果保留两位小数,采用ROUND_HALF_UP参数,也就是所谓的四舍五入.
     * */
    String strFinal = finalNum + "";
    BigDecimal decima2 = new BigDecimal(strFinal);
    BigDecimal setScale2 = decima2.setScale(2, BigDecimal.ROUND_HALF_UP);
    /*将四舍五入后的结果添加到arrayBD中*/
    araryBD.add(setScale2);

    System.out.printf("发红包后用户余额所剩：[%.2f] \n", blanceMoney);
    System.out.println(araryBD);

    return araryBD;
  }

  /**
   * 收红包.
   *
   * @param list .
   */
  public static void receiver(String username, ArrayList<BigDecimal> list) {

    //从多个红包重随机抽取一个给自己
    //随机获取一个集合当中的索引编号
    int index = new Random().nextInt(list.size());
    //将BigDecimal转换成deouble类型数据
    double tempValue = list.get(index).doubleValue();
    System.out.printf("用户名为:[%s]的用户抢到了[%.2f]元!", username, tempValue);
    //删除索引的元素
    list.remove(index);
  }
}
