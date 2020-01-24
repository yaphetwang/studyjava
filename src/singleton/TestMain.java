package singleton;

import java.lang.reflect.Constructor;

/**
 * @author wb-wyf372433
 * @date 2019/7/2 15:01
 * @description
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            LazyMan lazyMan1 = LazyMan.getInstance();
            LazyMan lazyMan2 = LazyMan.getInstance();
            //通过反射可以破坏单例模式
//            Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
//            declaredConstructor.setAccessible(true);
//            LazyMan lazyMan2 = declaredConstructor.newInstance();
            System.out.println(lazyMan1.hashCode());
            System.out.println(lazyMan2.hashCode());
            System.out.println(lazyMan1 == lazyMan2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}