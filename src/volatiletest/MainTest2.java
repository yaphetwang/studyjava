package volatiletest;

/**
 * @author wyf
 * @date 2019/8/17 9:51
 * @description    是指令重排,  还是 可见性的问题,  等待子路老师证明
 *
 *  volatile 可以保证有序性和可见性,  不能保证原子性
 *
 *  MESI协议
 * 这是Intel提出的，MESI协议也是相当复杂，在这里我就简单的说下：
 *  当一个CPU修改了Cache中的数据，会通知其他缓存了这个数据的CPU，
 *  其他CPU会把Cache中这份数据的Cache Line置为无效，要读取数据的话，
 *  直接去内存中获取，不会再从Cache中获取了。
 */
public class MainTest2 {
    //    volatile boolean running = true;
    boolean running = true;

    public void test() {
        System.out.println("test start....");
        while (running) {
            System.out.println("给CPU一点时间去获取最新的 running 值");
        }
        System.out.println("test end....");
    }

    public static void main(String[] args) {
        MainTest2 mainTest2 = new MainTest2();
        new Thread(mainTest2::test, "t1").start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
        mainTest2.running = false;
    }
}
