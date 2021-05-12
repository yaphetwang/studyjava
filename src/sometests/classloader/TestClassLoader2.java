package sometests.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author wangyafei
 * @date 2021/4/27 下午10:39
 * @description 类加载中的parent指向
 * <p>
 * 注意：这里的parent不是java的继承机制，而是类加载器中的一个实例属性，
 * 用于在类加载时的委托对象，parent属性定义在其所继承的ClassLoader中
 */
public class TestClassLoader2 {

    public static void main(String[] args) {

        ClassLoader systemLoader = TestClassLoader2.class.getClassLoader();
        System.out.println("系统类加载类：" + systemLoader);

        ClassLoader extLoader = systemLoader.getParent();
        System.out.println("系统类加载类的parent（扩展类加载类）：" + extLoader);

        ClassLoader bootClassLoader = extLoader.getParent();
        System.out.println("扩展类加载类的parent（启动类加载类）：" + bootClassLoader);


        String sysClassPath = System.getProperty("java.class.path");
        System.out.println("系统类加载器加载路径：" + sysClassPath);
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL[] urls = urlClassLoader.getURLs();
        System.out.println(urls);
    }
}
