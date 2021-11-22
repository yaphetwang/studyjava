package sometests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wyf
 * @date 2019/9/29 22:21
 * @description
 */
public class Test {
    public static void main(String[] args) {
        int a = 27 / 20;
        int b = 27 % 20 > 0 ? 1 : 0;
        System.out.println(a + b);
        System.out.println(27 / 20 + (27 % 20 > 0 ? 1 : 0));

        //set方法会进行如下校验
        //    private void rangeCheck(int index) {
        //        if (index >= size)
        //            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        //    }


        List<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());
        list.add(0);
        System.out.println(list.size());
        System.out.println(list);
        list.add(1);
        System.out.println(list.size());
        System.out.println(list);
        //会报错，必须先执行add()到指定位置的下标才能set
        //难道是为了保持内存使用连续
        list.set(2, 2);
        System.out.println(list);

    }
}
