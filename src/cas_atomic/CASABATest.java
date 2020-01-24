package cas_atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wyf
 * @date 2019/7/10 11:20
 * @description
 * 解决CAS的ABA问题
 *
 * 假设有三个步骤：
 * 修改150为50
 * 修改50为150
 * 修改150为90
 * 请仔细看，这三个步骤做的事情，一个变量刚开始是150，修改成了50，后来又被修改成了150！（又改回去了），
 * 最后如果这个变量是150，再改成90。这就是CAS中ABA的问题。
 *
 * 第三步，判断这个值是否是150，有两种不同的需求：
 * 没错啊，虽然这个值被修改了，但是现在被改回去了啊，所以第三步的判断是成立的。
 * 不对，这个值虽然是150，但是这个值曾经被修改过，所以第三步的判断是不成立的。
 *
 * 针对于第二个需求，我们可以用AtomicStampedReference来解决这个问题，
 * AtomicStampedReference支持泛型，其中有一个stamp的概念
 *
 */
public class CASABATest {

    public static void main(String[] args) {
        try {
            AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(150, 0);
            Thread thread1 = new Thread(() -> {
                Integer oldValue = atomicStampedReference.getReference();
                int stamp = atomicStampedReference.getStamp();
                if (atomicStampedReference.compareAndSet(oldValue, 50, 0, stamp + 1)) {
                    System.out.println("150->50 成功:" + (stamp + 1));
                }
            });
            thread1.start();

            Thread thread2 = new Thread(() -> {
                try {
                    //睡一会儿，是为了保证线程1 执行完毕
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer oldValue = atomicStampedReference.getReference();
                int stamp = atomicStampedReference.getStamp();
                if (atomicStampedReference.compareAndSet(oldValue, 150, stamp, stamp + 1)) {
                    System.out.println("50->150 成功:" + (stamp + 1));
                }
            });
            thread2.start();

            Thread thread3 = new Thread(() -> {
                try {
                    //睡一会儿，是为了保证线程1，线程2 执行完毕
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer oldValue = atomicStampedReference.getReference();
                int stamp = atomicStampedReference.getStamp();
                if (atomicStampedReference.compareAndSet(oldValue, 90, 0, stamp + 1)) {
                    System.out.println("150->90 成功:" + (stamp + 1));
                }
            });
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("现在的值是" + atomicStampedReference.getReference() + ";stamp是" + atomicStampedReference.getStamp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
