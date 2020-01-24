package sometests;

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
    }
}
