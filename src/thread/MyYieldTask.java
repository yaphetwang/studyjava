package thread;

/**
 * @author wyf
 * @date 2019/7/11 10:07
 * @description
 */
public class MyYieldTask implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("我是" + Thread.currentThread().getName() + "，我分配到了时间片");
            Thread.yield();
        }
    }
}
