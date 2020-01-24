package concurrency.sale_tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyf
 * @date 2019/8/17 22:20
 * @description 1000张火车票, 10个窗口来卖,  模拟
 * 防止超卖
 */
public class SaleOfTickets2 {
    private static List<Integer> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    //加锁保证操作的原子性
                    synchronized (tickets) {
                        if (tickets.size() > 0) {
                            System.out.println("销售票编号:" + tickets.remove(0));
                        }
                    }
                }
            }).start();
        }
    }
}