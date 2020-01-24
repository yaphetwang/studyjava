package singleton;

/**
 * @author wb-wyf372433
 * @date 2019/7/2 15:59
 * @description
 */
public class TestEnumMain {
    public static void main(String[] args) {
        SingletonEnum singleton1 = SingletonEnum.INSTANCE;
        SingletonEnum singleton2 = SingletonEnum.INSTANCE;
        System.out.println(singleton1.getClass());
        System.out.println(singleton2.getClass());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.get());
        System.out.println(singleton2.get());

        System.out.println("===================");
        EnumSingletonDemo demo = EnumSingletonDemo.getInstance();
        EnumSingletonDemo demo1 = EnumSingletonDemo.getInstance();
        System.out.println(demo.getClass());
        System.out.println(demo == demo1);
    }
}