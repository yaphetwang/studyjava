package hw;

import java.util.concurrent.Semaphore;

/**
 * @author wangyafei
 * @date 2024/4/27 09:54
 * @description
 */
public class CyclicPrintAbc3 {
    private static int max = 10;

    /**
     * 以A开始的信号量,初始信号量数量为1, 先执行A
     * B、C信号量,A完成后开始,初始信号数量为0
     */
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {

            try {
                for (int i = 0; i < max; i++) {
                    // A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    A.acquire();
                    System.out.print("A");
                    // B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {

            try {
                for (int i = 0; i < max; i++) {
                    // B获取信号执行,B信号量减1,当B为0时将无法继续获得该信号量
                    B.acquire();
                    System.out.print("B");
                    // C释放信号，C信号量加1（初始为0），此时可以获取C信号量
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadB.start();

        Thread threadC = new Thread(() -> {

            try {
                for (int i = 0; i < max; i++) {
                    // C获取信号执行,C信号量减1,当C为0时将无法继续获得该信号量
                    C.acquire();
                    System.out.print("C");
                    // A释放信号，A信号量加1（初始为0），此时可以获取A信号量
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadC.start();

    }
}
