package sometests.someutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangyafei
 * @date 2020/10/9 9:20 下午
 * @description  字符串截取
 */
public class StringUtils {

    public static void main(String[] args) {

        String category = "201162107$$汽车零部件/养护/美容/维保$$201329301$$本地化汽车服务-仅限邀约商家$$201329801$$洗车服务$$201333313$$标准洗车服务";

        System.out.println(getIndex(category, 2));
        System.out.println(getIndex(category, 3));
        System.out.println(category.substring(getIndex(category, 2) + 2, getIndex(category, 3)));

        int index2 = category.indexOf("$$", category.indexOf("$$") + 2);
        System.out.println(index2);
        System.out.println(category.substring(index2 + 2, category.indexOf("$$", index2 + 1)));

    }

    static int getIndex(String ss, int count) {
        //$为特殊字符，需转义
        Matcher findMatcher = Pattern.compile("\\$\\$").matcher(ss);
        int number = 0;
        while (findMatcher.find()) {
            number++;
            //当 "$$" 第二次出现时停止
            if (number == count) {
                break;
            }
        }
        //"$$"第二次出现的位置
        int index = findMatcher.start();
        return index;
    }
}
