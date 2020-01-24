package volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @author wb-wyf372433
 * @date 2019/7/8 16:12
 * @description 测试volatile
 * 看下面的方法: 按道理来说，3秒钟后，会打印出一句话，并且结束循环。
 * 但是，出人意料的事情发生了，等了很久，这句话迟迟没有出现，也没有结束循环。
 *
 * 线程的共享数据是存放在主内存的，每个线程都有自己的本地内存，本地内存是线程独享的。
 * 当一个线程需要共享数据，是先去本地内存中查找，如果找到的话，就不会再去主内存中找了，
 * 需要修改共享数据的话，是先把主内存的共享数据复制一份到本地内存,
 * 然后在本地内存中修改，再把数据复制到主内存。
 *
 * 如果把这个搞明白了，就很容易理解为什么会产生上面的情况了：
 * isStop是共享数据，放在了主内存，子线程需要这个数据，就把数据复制到自己的本地内存，
 * 此时isStop=false，以后直接读取本地内存就可以。
 * 主线程修改了isStop，子线程是无感知的，
 * 还是去本地内存中取数据，得到的isStop还是false，所以就造成了上面的情况。
 *
 * 因为JVM会尽力保证内存的可见性，
 * 即使这个变量没有加入Volatile关键字，只要CPU有时间，都会尽力保证拿到最新的数据。
 * 但是第一个例子中，CPU不停的在做着死循环，死循环内部就是判断isStop，
 * 没有时间去做其他的事情，但是只要给它一点机会，就像上面的 打印出一句话，
 * 这些操作都是比较耗时的，CPU就可能可以去拿到最新的数据了。
 * 不过和Volatile不同的是 Volatile是强制内存“可见性”，而这里是可能可以。
 *
 *
 */
public class MainTest1 {
    /**
     * 此变量值存在于主内存(即堆)中
     */
//    private static volatile boolean isStop = false;
    private static boolean isStop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println("给CPU一点时间去获取最新的值");
                if (isStop) {
                    System.out.println("结束");
                    return;
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
            isStop = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
