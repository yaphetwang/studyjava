package synchronize;

import java.util.concurrent.TimeUnit;

/**
 * @author wb-wyf372433
 * @date 2019/7/8 14:12
 * @description 测试 synchronized 关键字
 * 指令重排会有两个规则：
 * as-if-serial 规则
 *    不管怎么重排序，单线程的执行结果不能发生改变。
 *    正是由于这个特性，在单线程中，程序员一般无需理会重排序带来的问题。
 * happens-before
 *    程序次序规则: 一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作。
 *    volatile规则: 被Volatile标记的不允许指令重排。
 *                  那内部是如何禁止指令重排的呢?在指令中插入内存屏障。
 *                  在生成指令序列的时候，会根据具体情况插入不同的内存屏障。
 *    锁定规则: 如果锁处于Lock的状态，必须等Unlock后，才能再次进行Lock操作。
 *    传递规则: A happens-before B , B happens-before C，那么A happens-before C。
 *
 *
 * 锁与Monitor
 * JVM为每个对象都分配了一个monitor，syncrhoized就是利用monitor来实现加锁，解锁。
 * 同一时刻，只有一个线程可以获得monitor，并且执行被包裹的代码块或者方法，
 * 其他线程只能等待monitor释放，整个过程是互斥的。
 * monitor拥有一个计数器，当线程获取monitor后，计数器便会+1，释放monitor后，计数器便会-1。
 * 那么为什么会是+1，-1 的操作，而不是“获得monitor，计数器=1，释放monitor后，计数器=0”呢？
 * 这就涉及到 锁的重入性了,请看MainTest2
 *
 */
public class MainTest {
    private int num = 0;

    private synchronized void test() {
        for (int i = 0; i < 50; i++) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
        }
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                mainTest.test();
            }, "Hello,thread " + i).start();
        }

//        try {
//            TimeUnit.SECONDS.sleep(5);
//            System.out.println(mainTest.num);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}