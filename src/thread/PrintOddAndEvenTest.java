package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wyf
 * @date 2019/7/10 17:44
 * @description 交替打印奇偶数    和 一个线程打印奇数一个打印偶数， 逻辑不一样
 */
public class PrintOddAndEvenTest {

    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {

        //thread1，thread2 交替打印
        Thread thread1 = new Thread(new OddAndEvenRunnable());
        thread1.start();

        Thread thread2 = new Thread(new OddAndEvenRunnable());
        thread2.start();

        //thread3，thread4 分别打印奇偶数
        //AtomicInteger.get() 方法 不具有原子性
        Thread thread3 = new Thread(() -> {
            while (i.get() < 101) {
                if (i.get() % 2 == 0) {
                    System.out.println(Thread.currentThread() + ":" + i.getAndIncrement());
                }
            }
        });
        thread3.start();

        Thread thread4 = new Thread(() -> {
            while (i.get() < 101) {
                if (i.get() % 2 == 1) {
                    System.out.println(Thread.currentThread() + ":" + i.getAndIncrement());
                }
            }
        });
        thread4.start();
    }
}