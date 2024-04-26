package hw;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyafei
 * @date 2024/4/26 21:41
 * @description 三个线程循环打印 ABC  Condition实现
 */
public class CyclicPrintAbc2 {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int max = 10;
    private static int count = 3;

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < max; i++) {
                lock.lock();
                try {
                    //注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                    while (state % count != 0) {
                        // A释放lock锁
                        A.await();
                    }
                    System.out.print("A");
                    state++;
                    // A执行完唤醒B线程
                    B.signal();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < max; i++) {
                lock.lock();
                try {
                    while (state % count != 1) {
                        // B释放lock锁,当前面A线程执行后会通过B.signal()唤醒该线程
                        B.await();
                    }
                    System.out.print("B");
                    state++;
                    // B执行完唤醒C线程
                    C.signal();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        threadB.start();

        Thread threadC = new Thread(() -> {
            for (int i = 0; i < max; i++) {
                lock.lock();
                try {
                    while (state % count != 2) {
                        // C释放lock锁,当前面B线程执行后会通过C.signal()唤醒该线程
                        C.await();
                    }
                    System.out.print("C");
                    state++;
                    // C执行完唤醒A线程
                    A.signal();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        threadC.start();
    }


}
