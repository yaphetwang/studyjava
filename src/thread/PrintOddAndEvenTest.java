package thread;

/**
 * @author wyf
 * @date 2019/7/10 17:44
 * @description
 * 打印奇偶数
 */
public class PrintOddAndEvenTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new OddAndEvenRunnable());
        thread1.start();

        Thread thread2 = new Thread(new OddAndEvenRunnable());
        thread2.start();
    }
}