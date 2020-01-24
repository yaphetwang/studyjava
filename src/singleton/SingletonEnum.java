package singleton;

/**
 * @author wb-wyf372433
 * @date 2019/7/2 15:38
 * @description 懒汉式, 饿汉式  容易受到反射方法的攻击
 * 为了 彻底 防止 通过反射来破坏单例模式,
 * 使用枚举方式实现单例模式,
 * 因为通过反射 Constructor.newInstance 方法中有判断,即不允许通过反射创建枚举类对象
 * <p>
 * 首先，在枚举中我们明确了构造方法限制为私有，在我们访问枚举实例时会执行构造方法，
 * 同时每个枚举实例都是static final类型的，也就表明只能被实例化一次。
 * 在调用构造方法时，我们的单例被实例化。
 * 也就是说，因为enum中的实例被保证只会被实例化一次，所以我们的INSTANCE也被保证实例化一次。
 * <p>
 * SingletonEnum 底层是继承Enum抽象类的,
 * 里面的 实例方法和实例变量 都是final修饰的
 */
public enum SingletonEnum {
    INSTANCE;

    /**
     * 此构造器无须添加, 编译器会为我们默认添加 私有构造器,
     * 这是枚举的设计决定的
     */
    private SingletonEnum() {
        System.out.println("init");
    }

    /**
     * 定义一个实例方法
     */
    public String get() {
        return "枚举实现单例";
    }
}