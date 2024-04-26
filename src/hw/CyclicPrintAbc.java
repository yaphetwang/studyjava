package hw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyafei
 * @date 2024/4/26 21:01
 * @description 三个线程循环打印 ABC
 */
public class CyclicPrintAbc {

    /**
     * 三个线程共用一把锁
     */
    private static Lock lock = new ReentrantLock();
    /**
     * 对3取余，分配线程打印
     */
    private static int state = 0;

    private static int max = 10;
    private static int count = 3;

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < max; ) {
                lock.lock();
                try {
                    while (state % count == 0) {
                        System.out.print("A");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < max; ) {
                lock.lock();
                try {
                    while (state % count == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        threadB.start();

        Thread threadC = new Thread(() -> {
            for (int i = 0; i < max; ) {
                lock.lock();
                try {
                    while (state % count == 2) {
                        System.out.print("C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        threadC.start();
    }

}
