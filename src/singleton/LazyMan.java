package singleton;

/**
 * @author wb-wyf372433
 * @date 2019/7/2 15:00
 * @description 饿汉式 改造版本,即静态内部列方式,
 * 使用静态内部类,既保证了线程的安全性，同时又满足了懒加载
 */
public class LazyMan {
    private LazyMan() {
        //防止使用反射创建对象破坏单例模式
        synchronized (LazyMan.class) {
            if (getInstance() != null) {
                throw new RuntimeException("不要试图用反射破坏单例模式");
            }
        }
    }

    public static LazyMan getInstance() {
        return InnerClass.lazyMan;
    }

    private static class InnerClass {
        private static final LazyMan lazyMan = new LazyMan();
    }
}