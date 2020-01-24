package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author wyf
 * @date 2019/7/10 16:26
 * @description
 */
public class MyRunnableTest {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(3);
            synchronized (MyRunnable.class) {
                System.out.println("我是" + Thread.currentThread().getName() + "，我进入了临界区");
                MyRunnable.class.notify();
                //当调用共享变量的notify方法后，并没有释放共享变量的监视器锁，
                //只有退出临界区(方法执行完毕) 或者调用wait方法后，才会释放共享变量的监视器锁
                //让主线程 睡一会再释放锁
                //sleep 不会释放锁
                TimeUnit.SECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
