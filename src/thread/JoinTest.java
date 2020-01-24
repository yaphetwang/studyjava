package thread;

/**
 * @author wyf
 * @date 2019/7/11 22:18
 * @description
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinRunnable());
        thread1.start();
        Thread.currentThread().interrupt();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("主线程" + e.toString());
        }
    }
}