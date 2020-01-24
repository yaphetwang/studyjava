package sometests.classloader;

/**
 * @author wyf
 * @date 2019/10/2 10:40
 * @description
 */
public class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son() {
        System.out.println("我是儿子~");
    }
}
