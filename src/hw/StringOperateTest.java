package hw;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author wangyafei
 * @date 2024/4/2 10:32
 * @description 一些字符串操作 的笔试题
 */
public class StringOperateTest {

    /**
     * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，
     * 要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
     * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
     * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；
     * 大小写字母的数量相等时，不做转换。
     * 输入描述:
     * 输入为两行，第一行为参数K，第二行为字符串S。
     * 输出描述:
     * 输出转换后的字符串。
     * 示例1
     * 输入
     * 3
     * 12abc-abCABc-4aB@
     * 输出
     * 12abc-abc-ABC-4aB-@
     * 说明
     * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，转换为abc，ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int k = Integer.parseInt(scanner.nextLine());
            String[] strings = scanner.nextLine().split("-");
            String s = "";
            //去除第一个子串，拼接剩余的
            for (int i = 1; i < strings.length; i++) {
                s = s + strings[i];
            }

            int index = 0;
            StringBuilder sb = new StringBuilder();
            //第一个子串保留不处理
            sb.append(strings[0]);

            //这个切割方法 很巧妙
            while (s.length() - index > k) {
                sb.append("-" + caseConversion(s.substring(index, index + k)));
                index += k;
            }

            //剩余的不满足切割数量,直接拼接
            if (s.length() - index > 0) {
                sb.append("-" + caseConversion(s.substring(index)));
            }

            System.out.println(sb);

        }
    }

    private static String caseConversion(String s) {
        int upperCaseLength = s.length() - s.replaceAll("[A-Z]", "").length();
        int lowerCaseLength = s.length() - s.replaceAll("[a-z]", "").length();
        if (upperCaseLength > lowerCaseLength) {
            return s.toUpperCase(Locale.ROOT);
        }
        if (upperCaseLength < lowerCaseLength) {
            return s.toLowerCase(Locale.ROOT);
        }

        return s;
    }


}
