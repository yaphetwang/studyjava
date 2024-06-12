package concurrency.sale_tickets;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author wyf
 * @date 2019/8/17 22:20
 * @description 1000张火车票, 10个窗口来卖,  模拟
 * 防止超卖    ConcurrentLinkedQueue
 */
public class SaleOfTickets3 {
    private static Queue<Integer> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    Integer poll = tickets.poll();
                    if (poll == null) {
                        break;
                    }
                    System.out.println("销售票编号:" + poll);
                }
            }).start();
        }
    }
}