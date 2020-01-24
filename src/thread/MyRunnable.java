package thread;

/**
 * @author wyf
 * @date 2019/7/10 14:59
 * @description
 * 调用wait方法后，还会释放对共享变量的监视器锁，让其他线程可以进入临界区：
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                //在调用共享变量的wait方法前，
                //必须先对该共享变量进行synchronized操作，获得对象的监视器锁
                //否则会抛出IllegalMonitorStateException异常
                synchronized (MyRunnable.class) {
                    System.out.println("我是" + Thread.currentThread().getName() + "，我进入了临界区");
                    MyRunnable.class.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}