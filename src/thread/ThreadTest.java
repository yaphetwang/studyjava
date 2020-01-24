package thread;

import java.util.concurrent.FutureTask;

/**
 * @author wyf
 * @date 2019/7/10 15:03
 * @description 在面试中，经常会问如下的问题：
 *
 * 调用Thread的start方法会发生什么事情，线程会马上执行吗？
 * 不会，调用Thread的start方法，线程没有马上执行，它处于“就绪”的状态，需要获得CPU资源后才会执行。
 *
 * 调用Thread的start和run方法，有什么区别？
 * 调用start方法，才会真正开启新的线程执行run中的方法，
 * 而调用run方法，只是和调用普通方法一样，不会开启线程。
 *
 *
 * 上面三种方式的区别是什么，优缺点？
 * 只有Thread才是真正的线程，其他两种方法都需要被Thread包装才可以成为线程，
 * 在run方法中，可以使用this来获得当前线程，不需要使用Thread.currentThread()，
 * 缺点在于Java是单继承的，如果继承了Thread类，就没有办法继承其他类了，这是比较致命的，
 * 还有一个致命的缺点：无法交给线程池管理。
 * Runnable是接口，所以实现了Runnable接口，还可以继承其他的类，但是必须被Thread类包装才可以成为线程，可以被线程池管理。
 * 以上两种方法都是没有返回值的，所以第三种方式Callable出现了，也可以被线程池管理，同样的，也必须被Thread类包装才可以成为线程。
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception {
//        Thread1 thread1 = new Thread1();
//        thread1.start();

        //首先新建了一个子线程，子线程内部获取了object的监视器锁，
        // 随后调用object的wait方法阻塞当前线程，
        //主线程调用interrupt方法中断子线程，子线程被返回,并且产生了异常。
        //这也就是为什么我们在调用共享变量的wait方法的时候,
        // Java“死皮赖脸”的要我们对异常进行处理的原因
        Thread2 thread2 = new Thread2();
        Thread thread = new Thread(thread2);
        thread.start();
        thread.interrupt();

//        FutureTask<String> futureTask = new FutureTask<>(new Thread3());
//        new Thread(futureTask).start();
//        System.out.println(futureTask.get());

    }

}
