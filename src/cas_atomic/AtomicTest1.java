package cas_atomic;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wyf
 * @date 2019/7/9 10:06
 * @description 测试原子操作类,
 * 核心是通过 Unsafe 类的 几个方法
 *    objectFieldOffset：接收一个Field类型的数据，返回偏移地址。
 *    getIntVolatile：获得值，支持Volatile，接收两个参数：实例，偏移地址。
 *    compareAndSwapInt：比较交换，接收四个参数：实例，偏移地址，预期值，新值。
 * 最终实现是会调用到C或者C++, 把对应的指令发送给CPU，这是可以保证原子性的。
 *
 * 我们来为compareAndSwapInt方法做一个比较形象的解释：
 * 当我们执行compareAndSwapInt方法，传入10和100，
 * Java会和更底层进行通信：老铁，我给你了字段的所属实例和偏移地址，
 * 你帮我看下这个字段的值是不是10，如果是10的话，你就改成100，并且返回true，如果不是的话，不用修改，返回false吧。
 * 其中比较的过程就是compare，修改的值的过程就是swap，
 * 因为是把旧值替换成新值，所以我们把这样的操作称为CAS。
 */
public class AtomicTest1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        new Thread(() -> {
            System.out.println(atomicInteger.get());
            if (!atomicInteger.compareAndSet(0, 100)) {
                System.out.println("0-100:失败");
            }
            System.out.println(atomicInteger.get());
        }).start();

        new Thread(() -> {
            try {
                //注意这里睡了一会儿，目的是让第三个线程先执行判断的操作，从而让第三个线程修改失败
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!atomicInteger.compareAndSet(100, 50)) {
                System.out.println("100-50:失败");
            }
        }).start();

        new Thread(() -> {
            System.out.println(atomicInteger.get());
            if (!atomicInteger.compareAndSet(50, 60)) {
                System.out.println("50-60:失败");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
