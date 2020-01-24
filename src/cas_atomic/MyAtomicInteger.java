package cas_atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wyf
 * @date 2019/7/9 15:47
 * @description 自定义一个原子操作类
 * 核心是通过 Unsafe 类的 几个方法
 * objectFieldOffset：接收一个Field类型的数据，返回偏移地址。
 * getIntVolatile：获得值，支持Volatile，接收两个参数：实例，偏移地址。
 * compareAndSwapInt：比较交换，接收四个参数：实例，偏移地址，预期值，新值。
 * 最终实现是会调用到C或者C++, 把对应的指令发送给CPU，这是可以保证原子性的。
 */
public class MyAtomicInteger {
    private volatile int value;

    private static Unsafe unsafe;
    //偏移地址
    private static long valueOffset;

    static {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
            //获得偏移地址
            valueOffset = unsafe.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increment(int num) {
        int tempValue;
        do {
            //拿到值
            tempValue = unsafe.getIntVolatile(this, valueOffset);
            //CAS自旋
        } while (!unsafe.compareAndSwapInt(this, valueOffset, tempValue, tempValue + num));
    }

    public int get() {
        return value;
    }

}
