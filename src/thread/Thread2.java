package thread;

/**
 * @author wyf
 * @date 2019/7/10 14:59
 * @description
 */
public class Thread2 implements Runnable {

    Object object = new Object();

    @Override
    public void run() {
        System.out.println("Thread2 run");

        try {
            synchronized (object) {
                object.wait();
                System.out.println("run");
            }
        } catch (InterruptedException e) {
            System.out.println("被中断了");
            e.printStackTrace();
        }
    }
}
