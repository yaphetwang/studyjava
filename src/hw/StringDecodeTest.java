package hw;

import java.util.Stack;

/**
 * @author wangyafei
 * @date 2024/4/27 10:55
 * @description 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，
 * 表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class StringDecodeTest {
    //使用栈来进行处理

    private static String s = "3[a2[c]]";
    private static String s1 = "abc3[cd]xyz";

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                //把所有的字母push进去，除了 ]
                stack.push(c);
            } else {
                //碰到 ]

                //step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    //插前面，顺序已经排好
                    sb.insert(0, stack.pop());
                }

                //[ ]内的字符串
                String sub = sb.toString();
                //弹出 删除 [
                stack.pop();

                //step 2: 获取倍数数字
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                //倍数
                int count = Integer.valueOf(sb.toString());

                //step 3: 根据倍数把字母再push回去

                for (int i = 0; i < count; i++) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                }

            }
        }

        //把栈里面所有的字母取出来
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        System.out.println(result);

        System.out.println(decode(s));
    }

    /**
     * 双栈处理
     */
    public static String decode(String s) {
        //3[a2[c]]
        //abc3[cd]xyz
        StringBuffer ans = new StringBuffer();
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {

                multi = multi * 10 + c - '0';

            } else if (c == '[') {
                //碰到 [, 前面挨着肯定出现一个数字 multi 有值了
                ansStack.push(ans);
                multiStack.push(multi);
                //重置，拼接[] 中的字符
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else {
                //碰到 ]
                StringBuffer ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) {
                    ansTmp.append(ans);
                }
                //重置
                ans = ansTmp;
            }
        }

        return ans.toString();
    }
}
