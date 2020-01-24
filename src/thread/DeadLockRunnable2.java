package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wyf
 * @date 2019/7/11 21:25
 * @description
 */
public class DeadLockRunnable2 implements Runnable {
    @Override
    public void run() {
        try {
            synchronized (Lock2.class) {
                System.out.println(Thread.currentThread().getName() + "获取了Lock2,准备去获取Lock1......");
                TimeUnit.SECONDS.sleep(2);
                synchronized (Lock1.class) {
                    System.out.println(Thread.currentThread().getName() + "获取了Lock1......");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
