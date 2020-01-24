package volatiletest;

/**
 * @author wyf
 * @date 2019/12/4 21:56
 * @description 查看volatile 字节码指令, 搞明白volatile实现机制
 *  lock指令
 */
public class VolatileTest {
    private static volatile VolatileTest volatileTest = null;

    private VolatileTest() {
    }

    public static VolatileTest getVolatileTest() {
        if (null == volatileTest) {
            synchronized (VolatileTest.class){
                if (null == volatileTest) {
                    volatileTest = new VolatileTest();
                }
            }
        }
        return volatileTest;
    }

    public static void main(String[] args) {
        System.out.println(VolatileTest.getVolatileTest());
    }
}
