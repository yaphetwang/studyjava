package thread;

/**
 * @author wyf
 * @date 2019/7/11 21:46
 * @description
 * 守护线程
 * main主线程 结束之后 , 守护线程不管有没有执行完,也会立刻结束
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
