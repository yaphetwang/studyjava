package thread;

/**
 * @author wyf
 * @date 2019/7/11 22:17
 * @description
 */
public class JoinRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("测试join....");
        Thread.currentThread().interrupt();
    }
}
