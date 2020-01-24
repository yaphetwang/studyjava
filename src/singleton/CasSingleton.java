package singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wyf
 * @date 2019/11/5 11:25
 * @description   cas  实现单例模式
 */
public class CasSingleton {

    private CasSingleton() {
    }

    private static AtomicReference<CasSingleton> singletonAtomicReference = new AtomicReference<>();

    public static CasSingleton getInstance() {
        while (true) {
            CasSingleton singleton = singletonAtomicReference.get();// 获得singleton
            if (singleton != null) {// 如果singleton不为空，就返回singleton
                return singleton;
            }
            // 如果singleton为空，创建一个singleton
            singleton = new CasSingleton();
            // CAS操作，预期值是NULL，新值是singleton
            // 如果成功，返回singleton
            // 如果失败，进入第二次循环，singletonAtomicReference.get()就不会为空了
            if (singletonAtomicReference.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

}