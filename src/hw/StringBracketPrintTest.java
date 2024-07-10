package hw;

import java.util.Stack;

/**
 * @author wangyafei
 * @date 2024/6/19 10:42
 * @description 华为技术三面  字符串中 括号下标成对 打印
 */
public class StringBracketPrintTest {
    public static void main(String[] args) {
        String s = "(ab){c(d[ef()g{h}])ij}";
        Stack<Integer> stack = new Stack<>();
        char a1 = '(';
        char a2 = ')';
        char b1 = '[';
        char b2 = ']';
        char c1 = '{';
        char c2 = '}';

        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            if (d == a1 || d == b1 || d == c1) {
                stack.push(i);
            } else if (d == a2 || d == b2 || d == c2) {
                System.out.println(stack.pop() + " " + i);
            }
        }
    }
}
