package hw;

/**
 * @author wangyafei
 * @date 2024/6/15 10:26
 * @description  华为技术一面  最短回文串
 * 通过在 给定字符串前面添加字符 形成最短回文串
 */
public class MinString {

    public static void main(String[] args) {
        String s = "aAbcd";

        int n = s.length();
        int b = 131;
        int m = 1000000007;
        int left = 0,right = 0;
        int mul = 1;
        int be = -1;

        for (int i = 0; i < n; i++) {
            left = (int) (((long) left * b + s.charAt(i)) % m);
            right = (int) ((right + (long) mul * s.charAt(i)) % m);
            //字符相同
            if (left == right) {
                be = i;
            }
            mul = (int) ((long) mul * b % m);
        }

        //需要添加的
        String a = (be == n - 1 ? "" : s.substring(be + 1));
        StringBuilder sb = new StringBuilder(a).reverse();
        sb.append(s);
        System.out.println(sb);
    }
}
