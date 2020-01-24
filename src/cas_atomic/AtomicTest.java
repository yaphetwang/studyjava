package cas_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wyf
 * @date 2019/7/9 10:06
 * @description 测试原子操作类
 * 在高并发的情况下，这种方法会比Synchronized更有优势，
 * 毕竟Synchronized关键字会让代码串行化，失去了多线程优势。
 */
public class AtomicTest {

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
            threads[i].start();
        }
        join(threads);
        System.out.println("x=" + atomicInteger.get());
    }

    private static void join(Thread[] threads) {
        for (int i = 0; i < 20; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
