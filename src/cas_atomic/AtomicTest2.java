package cas_atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangyafei
 * @date 2022/3/23 10:27 下午
 * @description 100个线程，顺序打印出 1-100
 */
public class AtomicTest2 {

    static AtomicInteger atomicInteger = new AtomicInteger(1);

    static volatile int a = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    print();
                    System.out.println(a++);
                }
            });
            thread.start();
        }
    }

    static synchronized void print() {
//        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(a++);
    }
}
