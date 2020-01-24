package concurrency.sale_tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyf
 * @date 2019/8/17 22:20
 * @description 1000张火车票, 10个窗口来卖,  模拟
 * 此种方式  超卖,下标越界异常 会出现
 */
public class SaleOfTickets1 {
    private static List<Integer> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //判断数量和输出  不具有原子性
                while (tickets.size() > 0) {
                    System.out.println("销售票编号:" + tickets.remove(0));
                }
            }).start();
        }
    }
}
