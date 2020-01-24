package thread;

/**
 * @author wyf
 * @date 2019/7/10 14:59
 * @description 调用wait方法后，还会释放对共享变量的监视器锁，让其他线程可以进入临界区：
 * notify 方法 , 唤醒 等待当前锁对象的线程 进入等待状态
 * notify 不会立刻释放锁, 只有方法执行完 才释放锁
 *
 */
public class OddAndEvenRunnable implements Runnable {

    private static int i = 0;

    @Override
    public void run() {
        try {
            while (i < 101) {
                synchronized (OddAndEvenRunnable.class) {
                    System.out.println("我是" + Thread.currentThread() + "：" + i++);
                    OddAndEvenRunnable.class.notify();
                    OddAndEvenRunnable.class.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}