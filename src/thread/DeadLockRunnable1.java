package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wyf
 * @date 2019/7/11 21:25
 * @description
 */
public class DeadLockRunnable1 implements Runnable {
    @Override
    public void run() {
        try {
            synchronized (Lock1.class) {
                System.out.println(Thread.currentThread().getName() + "获取了Lock1,准备去获取Lock2......");
                TimeUnit.SECONDS.sleep(3);
                synchronized (Lock2.class) {
                    System.out.println(Thread.currentThread().getName() + "获取了Lock2......");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
