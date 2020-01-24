package synchronize;

/**
 * @author wb-wyf372433
 * @date 2019/7/8 15:16
 * @description
 * Synchronized与有序性，可见性
 * 编译器，CPU会在不影响单线程程序最终执行的结果的情况下进行“指令重排”。
 * 这就是“ self-if-serial”规则。
 * 在单线程中，我们可能并不需要关心指令重排，
 * 因为无论背后进行了多么翻天覆地的“指令重排”都不会影响到最终的执行结果，
 * 但是self-if-serial是针对于单线程的，对于多线程，会有第二个规则：happens-before。
 * happens-before用来表述两个操作之间的关系。如果A happens-before B，也就代表A发生在B之前。
 * 由于两个操作可能处于不同的线程，happens-before规定，
 * 如果一个线程A happens-before另外一个线程B，那么A对B可见，
 * 正是由于这个规定，我们说Synchronized保证了线程的“可见性”。
 * Synchronized具体是怎么做的呢？
 * 当我们获得锁的时候，执行同步代码，线程会被强制从主内存中读取数据，
 * 先把主内存的数据复制到本地内存，然后在本地内存进行修改，
 * 在释放锁的时候，会把数据写回主内存。
 *
 * 而Synchronized的同步特性，显而易见的保证了“有序性”, 也保证了操作的原子性。
 *
 * 总结一下，Synchronized既可以保证“原子性”，又可以保证“可见性”，还可以保证“有序性”。
 *
 */
public class MainTest1 {
    public synchronized void Hello(){
        System.out.println("Hellol");
    }
    public static void main(String[] args) {

    }
}