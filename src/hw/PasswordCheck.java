package hw;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author wangyafei
 * @date 2024/4/11 16:24
 * @description 密码验证合格程序 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 */
public class PasswordCheck {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String str = in.nextLine();

            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (getMatch(str)) {
                System.out.println("NG");
                continue;
            }
            if (getString(str, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");

        }
    }

    // 校验是否有重复子串
    //private static boolean reStr(String s) {
    //    for (int i = 3; i < s.length(); i++) {
    //        if (s.substring(i).contains(s.substring(i - 3, i))) {
    //            return false;
    //        }
    //    }
    //    return true;
    //}

    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str, l + 1, r + 1);
        }
    }

    /**
     * 检查是否满足正则
     */
    private static boolean getMatch(String str) {
        int count = 0;
        Pattern bigChar = Pattern.compile("[A-Z]");
        if (bigChar.matcher(str).find()) {
            count++;
        }
        Pattern minChar = Pattern.compile("[a-z]");
        if (minChar.matcher(str).find()) {
            count++;
        }
        Pattern number = Pattern.compile("[0-9]");
        if (number.matcher(str).find()) {
            count++;
        }
        Pattern oChar = Pattern.compile("[^a-zA-Z0-9]");
        if (oChar.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }

}
