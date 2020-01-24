package thread;

/**
 * @author wyf
 * @date 2019/7/11 22:11
 * @description
 * interrupt方法不会中断正在运行的线程
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new InterruptTask());
        thread1.start();
//        thread1.interrupt();
    }
}
