package jdk8;

/**
 * @author wyf
 * @date 2020/1/31 9:10 下午
 * @description
 *
 *   测试switch ，  多个case 匹配同一段逻辑
 */
public class SwitchTest {


    public static void main(String[] args) {
        test(4);
        test(5);
        test(6);
        test(7);
        test(8);
    }

    private static void test(int value) {
        switch (value) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("1");
                break;
            case 6:
            case 7:
                System.out.println("0");
                break;
            default:
                System.out.println("-1");
        }
    }

}
