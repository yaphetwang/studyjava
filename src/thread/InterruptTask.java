package thread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wyf
 * @date 2019/7/11 22:09
 * @description
 */
public class InterruptTask implements Runnable {
    @Override
    public void run() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                copyOnWriteArrayList.add(i);
            }
            System.out.println("结束了,时间是" + (System.currentTimeMillis() - start));
            System.out.println(Thread.currentThread().isInterrupted());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
