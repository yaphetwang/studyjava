package synchronize;


/**
 * @author wyf
 * @date 2019/10/3 21:23
 * @description 测试锁的粒度, 调用同步方法
 * <p>
 * 众所周知 synchronized 关键字是解决并发问题常用解决方案，有以下三种使用方式:
 * <p>
 * 同步普通方法，锁的是当前对象(类创建的当前对象)
 * 同步静态方法，锁的是当前 Class 对象
 * 同步块，锁的是 () 中的对象
 */
public class MainTest3 {

    public synchronized void test() {
        try {
            //模拟方法耗时
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行了方法");
    }

    public static void main(String[] args) {
        MainTest3 instance1 = new MainTest3();
        MainTest3 instance2 = new MainTest3();
        new Thread(() -> {
            instance1.test();
        }, "Hello,thread1 ").start();

        new Thread(() -> {
            //同步普通方法，锁的是当前对象
            //thread1和thread2 会互斥
            instance1.test();
        }, "Hello,thread2 ").start();

        new Thread(() -> {
            //不会形成互斥
            instance2.test();
        }, "Hello,thread3 ").start();

    }
}