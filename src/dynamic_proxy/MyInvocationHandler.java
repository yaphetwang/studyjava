package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wb-wyf372433
 * @date 2019/7/1 10:39
 * @description
 */
public class MyInvocationHandler implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入了invoke");
        method.invoke(target);
        System.out.println("执行了invoke");
        return null;
    }
}
