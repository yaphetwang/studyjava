package sometests.classloader;

/**
 * @author wyf
 * @date 2019/10/2 10:39
 * @description
 */
public class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }

    public Grandpa() {
        System.out.println("我是爷爷~");
    }
}
