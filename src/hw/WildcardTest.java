package hw;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author wangyafei
 * @date 2024/4/5 16:23
 * @description 在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。
 * 现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 * <p>
 * 注意：匹配时不区分大小写。
 */
public class WildcardTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String value = in.nextLine();
            String target = in.nextLine();
            value = value.toLowerCase(Locale.ROOT);
            target = target.toLowerCase(Locale.ROOT);

            String regx = value.replaceAll("\\*{2,}", "\\*");
            regx = regx.replaceAll("\\?", "[0-9a-z]{1}");
            regx = regx.replaceAll("\\*", "[0-9a-z]{0,}");
            System.out.println(target.matches(regx));
        }

    }

}
