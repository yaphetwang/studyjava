package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author wyf
 * @date 2019/10/5 15:32
 * @description 了解线程池 的常用参数
 * 核心参数:
 * int corePoolSize 核心线程数, 线程池的基本大小
 * int maximumPoolSize 线程池最大线程数量
 * long keepAliveTime,TimeUnit unit 线程空闲后的存活时间
 * BlockingQueue<Runnable> workQueue 用于存放任务的阻塞队列
 * RejectedExecutionHandler handler 当队列和最大线程池都满了之后的饱和策略,
 * 线程池的饱和策略事件，主要有四种类型
 * <p>
 * 四种拒绝策略:
 * AbortPolicy(抛出一个异常，默认的)
 * DiscardPolicy(直接丢弃任务)
 * DiscardOldestPolicy（丢弃队列里最老的任务，将当前这个任务继续提交给线程池）
 * CallerRunsPolicy（交给线程池调用所在的线程进行处理)
 */
public class TestThreadPoolParam {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 3, SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 1; i < 5; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    //模拟方法耗时
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "执行了方法");
            });
        }

        //待全部线程执行完, 再关闭线程池
        threadPoolExecutor.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ExecutorService executorService3 = Executors.newScheduledThreadPool(1);


        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();
    }

}