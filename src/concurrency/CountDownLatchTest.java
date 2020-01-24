package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wyf
 * @date 2019/8/17 11:42
 * @description CountDownLatch   倒数闩, 顾名思义, 门闩
 */
public class CountDownLatchTest {
    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchTest c = new CountDownLatchTest();

        //latch.countDown();  每次调用都会减1, 减到0的时候latch.await();取消准备
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start...");
            if (c.size() != 5) {
                try {
                    latch.await(); //准备
                } catch (InterruptedException e) {
                }
            }
            System.out.println("t2 end...");
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start...");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add" + i);
                if (c.size() == 5) {
                    latch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("t1 end...");
        }, "t1").start();
    }
}
