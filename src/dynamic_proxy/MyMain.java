package dynamic_proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author wb-wyf372433
 * @date 2019/7/1 10:43
 * @description
 */
public class MyMain {
    public static void main(String[] args) {
//        MyInvocationHandler handler = new MyInvocationHandler(new UserServiceImpl());
//        Object o = Proxy.newProxyInstance(MyMain.class.getClassLoader(), new Class[]{UserService.class}, handler);
//        ((UserService) o).query();

        //看一下 生成的代理类的二进制数据
        byte[] $proxies = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{UserService.class});
        File file=new File("D:\\$Proxy.class");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            try {
                outputStream.write($proxies);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}