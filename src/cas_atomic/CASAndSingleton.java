package cas_atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wyf
 * @date 2019/7/9 16:32
 * @description 用CAS 来实现单例模式
 */
public class CASAndSingleton {

    private CASAndSingleton() {
    }

    private static AtomicReference<CASAndSingleton> singletonAtomicReference = new AtomicReference<>();

    public static CASAndSingleton getInstance() {
        while (true) {
            CASAndSingleton casAndSingleton = singletonAtomicReference.get();
            if (casAndSingleton != null) {
                return casAndSingleton;
            }

            casAndSingleton = new CASAndSingleton();
            // CAS操作，预期值是NULL，新值是singleton
            // 如果成功，返回singleton
            // 如果失败，进入第二次循环，singletonAtomicReference.get()就不会为空了
            if (singletonAtomicReference.compareAndSet(null, casAndSingleton)) {
                return casAndSingleton;
            }
        }
    }
}
