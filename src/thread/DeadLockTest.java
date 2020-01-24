package thread;

/**
 * @author wyf
 * @date 2019/7/11 21:37
 * @description
 * 测试死锁
 */
public class DeadLockTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DeadLockRunnable1());
        thread1.start();

        Thread thread2 = new Thread(new DeadLockRunnable2());
        thread2.start();
    }

}
