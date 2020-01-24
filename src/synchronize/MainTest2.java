package synchronize;

/**
 * @author wb-wyf372433
 * @date 2019/7/8 15:16
 * @description
 * 测试锁的重入性
 *
 * 主线程获取了类锁，打印出 “第一个synchronized”，紧接着主线程又获取了类锁，打印出“第二个synchronized”。
 * 问题来了，第一个类锁明明还没有释放，下面又获取了这个类锁。
 * 如果没有“锁的重入性”，这里应该只会打印出 “第一个synchronized”，然后程序就死锁了，
 * 因为它会一直等待释放第一个类锁，但是却永远等不到那一刻。
 *
 * 这也就是解释了为什么会是“当线程获取monitor后，计数器便会+1，释放monitor后，计数器便会-1“这样的设计。
 * 只有当计数器=0，才代表monitor已经被释放。第二个线程才能再次获取monitor。
 * 当然，锁的重入性是针对于同一个线程来说。
 */
public class MainTest2 {

    public static void main(String[] args) {
        synchronized (MainTest2.class) {
            System.out.println("第一个synchronized");
            synchronized (MainTest2.class) {
                System.out.println("第二个synchronized");
                synchronized (MainTest2.class) {
                    System.out.println("第三个synchronized");
                }
            }
        }
    }
}