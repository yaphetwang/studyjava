package singleton;

/**
 * @author wyf
 * @date 2019/10/7 11:41
 * @description
 */
public class EnumSingletonDemo {

    private EnumSingletonDemo() {
    }

    //延迟加载
    private enum EnumHolder {
        INSTANCE;
        private static EnumSingletonDemo instance = null;

        //懒加载
        private EnumSingletonDemo getInstance() {
            if (instance == null) {
                instance = new EnumSingletonDemo();
            }
            return instance;
        }
    }

    public static EnumSingletonDemo getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }
}