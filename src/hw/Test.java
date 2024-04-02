package hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wangyafei
 * @date 2024/4/2 15:26
 * @description
 */
public class Test {

    public static void main(String[] args) {
        //16进制转十进制
        String str = "0xAA";
        System.out.println(Integer.parseInt(str.substring(2), 16));

        //分解质因数
        int num = 180;
        getPrimer(num);

        //取近似值
        //写出一个程序，接受一个正浮点数值，输出该数值的近似整数值
        //如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整
        double number = 5.5;
        System.out.println((int) (number + 0.5));

        //提取不重复的整数,按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
        String s = "9876673";
        String result = "";
        for (int i = s.length(); i > 0; i--) {
            if (!result.contains(s.substring(i - 1, i))) {
                result += s.substring(i - 1, i);
            }
        }
        System.out.println(result);

        //字符个数统计,输出不同的字符个数
        String s1 = "abc";
        Set set = new HashSet();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        System.out.println(set.size());

        //数字反转
        String s2 = "abc";
        StringBuilder sb = new StringBuilder(s2);
        System.out.println(sb.reverse().toString());

        String s3 = "I am a boy";
        String[] strings = s3.split(" ");
        StringBuilder sb1 = new StringBuilder();
        for (int i = strings.length; i > 0; i--) {
            sb1.append(strings[i - 1] + " ");
        }
        System.out.println(sb1);

        //字典排序
        TreeSet set1 = new TreeSet();
        set1.add("cap");
        set1.add("card");
        set1.add("boat");
        set1.add("too");
        System.out.println(set1);

        //Arrays.sort(array); 字典排序
        String[] array = new String[5];
        //Arrays.sort(array);

        //十进制转二进制
        int num1 = 42;
        String bs = Integer.toBinaryString(num1);
        System.out.println(bs);
        System.out.println(bs.length() - bs.replaceAll("1", "").length());

    }


    public static void getPrimer(long num) {
        //分解从2开始，递归
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                getPrimer(num / i);
                break;
            }
            if (i == num) {
                System.out.print(i + "");
            }
        }
    }

}
