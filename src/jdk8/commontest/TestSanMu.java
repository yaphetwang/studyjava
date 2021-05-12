package jdk8.commontest;


/**
 * @author wangyafei
 * @date 2021/5/8 下午2:26
 * @description 测试三目表达式 处理包装类 拆装箱导致的 NPE问题
 */
public class TestSanMu {

    public static void main(String[] args) {

        boolean flag = true; //设置成true，保证表达式 2 被执行
        Long simpleInt = 66L;
        Long nullInteger = null;
        Long result = flag ? nullInteger : Long.valueOf(66L);
        System.out.println(result);


    }


}
