package thread;

/**
 * @author wyf
 * @date 2019/7/11 10:09
 * @description
 */
public class MyYieldTaskTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyYieldTask());
        thread1.start();

        Thread thread2 = new Thread(new MyYieldTask());
        thread2.start();
    }
}
