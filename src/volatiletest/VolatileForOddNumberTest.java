package volatiletest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile + lock   打印奇偶数
 */
public class VolatileForOddNumberTest {
    private int start=1;

    private int m;

    public VolatileForOddNumberTest(int start,int m){
        this.start=start;
        this.m=m;

    }

    /**
     * volatile
     */
    private volatile boolean flag = false;
    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        VolatileForOddNumberTest.printNumber(50);
    }


    private static void printNumber(int N){
        VolatileForOddNumberTest twoThread = new VolatileForOddNumberTest(1,N);

        Thread t1 = new Thread(new OuNum(twoThread));
        t1.setName("t1 偶数");

        Thread t2 = new Thread(new JiNum(twoThread));
        t2.setName("t2 奇数");

        t1.start();
        t2.start();

    }


    /**
     * 偶数线程
     */
    public static class OuNum implements Runnable {

        private VolatileForOddNumberTest number;

        public OuNum(VolatileForOddNumberTest number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= number.m) {

                if (number.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + number.start);
                        number.start++;
                        number.flag = false;

                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }
    }

    /**
     * 奇数线程
     */
    public static class JiNum implements Runnable {

        private VolatileForOddNumberTest number;

        public JiNum(VolatileForOddNumberTest number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= number.m) {

                if (!number.flag) {
                    try {
                        LOCK.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + number.start);
                        number.start++;
                        number.flag = true;

                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }
    }
}