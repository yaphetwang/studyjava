package cas_atomic;

/**
 * @author wyf
 * @date 2019/7/9 16:25
 * @description
 */
public class TestMyAtomicInteger {
    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    myAtomicInteger.increment(1);
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("x=" + myAtomicInteger.get());
    }
}
