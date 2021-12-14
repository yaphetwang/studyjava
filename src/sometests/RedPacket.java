package sometests;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyafei
 * @date 2021/12/5 7:49 下午
 * @description 红包算法
 */
public class RedPacket {
    /**
     * 生成红包最小值 1分
     */
    private static final int MIN_MONEY = 1;

    /**
     * 生成红包最大值 90人民币
     */
//    private static final int MAX_MONEY = 200;

    /**
     * 最大的红包是平均值的 TIMES 倍，防止某一次分配红包较大
     */
    private static final double TIMES = 0.9F;

    /**
     * 小于最小值
     */
    private static final int LESS = -1;
    /**
     * 大于最大值
     */
    private static final int MORE = -2;

    /**
     * 正常值
     */
    private static final int OK = 1;

    private int recursiveCount = 0;

    public List<Double> splitRedPacket(int money, int count) {
        List<Double> moneys = new LinkedList<>();

        List<Integer> moneyInt = new LinkedList<>();

        //计算出最大红包
        money = money * 100;
        int max = (int) (money * TIMES);

        for (int i = 0; i < count; i++) {
            //随机获取红包
            int redPacket = randomRedPacket(money, MIN_MONEY, max, count - i);
//            moneyInt.add(redPacket);

            moneys.add(new BigDecimal(redPacket).divide(new BigDecimal(100), 2,
                    RoundingMode.UNNECESSARY).doubleValue());
            //总金额每次减少
            money -= redPacket;
        }

//        int sum = 0;
//        for (Integer red : moneyInt) {
//            sum += red;
//        }
//        System.out.println(sum);

        return moneys;
    }

    private int randomRedPacket(int totalMoney, int minMoney, int maxMoney, int count) {
        //只有一个红包直接返回
        if (count == 1) {
            return totalMoney;
        }

        if (minMoney == maxMoney) {
            return minMoney;
        }

        //如果最大金额大于了剩余金额 则用剩余金额 因为这个 money 每分配一次都会减小
        maxMoney = maxMoney > totalMoney ? totalMoney : maxMoney;

        //在 minMoney到maxMoney 生成一个随机红包
        int redPacket = (int) (Math.random() * (maxMoney - minMoney) + minMoney);

        int lastMoney = totalMoney - redPacket;

        int status = checkMoney(lastMoney, count - 1, maxMoney);

        //正常金额
        if (OK == status) {
            return redPacket;
        }

        //如果生成的金额不合法 则递归重新生成
        if (LESS == status) {
            recursiveCount++;
            System.out.println("recursiveCount==" + recursiveCount);
            return randomRedPacket(totalMoney, minMoney, redPacket, count);
        }

        if (MORE == status) {
            recursiveCount++;
            System.out.println("recursiveCount===" + recursiveCount);
            return randomRedPacket(totalMoney, redPacket, maxMoney, count);
        }

        return redPacket;
    }

    /**
     * 校验剩余的金额的平均值是否在 最小值和最大值这个范围内
     *
     * @param lastMoney
     * @param count
     * @return
     */
    private int checkMoney(int lastMoney, int count, int maxMoney) {
        double avg = lastMoney / count;
        if (avg < MIN_MONEY) {
            return LESS;
        }
        if (avg > maxMoney) {
            return MORE;
        }
        return OK;
    }

    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket();
        List<Double> redPackets = redPacket.splitRedPacket(100, 10);
        System.out.println(redPackets);

        BigDecimal b = new BigDecimal(0);
        for (Double red : redPackets) {
            b = b.add(new BigDecimal(red));
        }

        System.out.println(b.doubleValue());

    }

}
