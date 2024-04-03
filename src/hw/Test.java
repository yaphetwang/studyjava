package hw;

import java.time.LocalDate;
import java.util.*;

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

        //字母ASCII码
        //在Java中，char 类型用于表示单一的16位字符，其值必须在\u0000到\uffff（0到65535）之间，可以表示大多数常用Unicode字符。
        //在标准ASCII码中，大写英文字母的ASCII值从65开始，到90结束，对应于字母A到Z。
        //小写英文字母的ASCII值则从97开始，到122结束，对应于字母a到z。数字0的ASCII值为48
        //A变a，再右移一位变为b
        char c = 'A';
        System.out.println((char) (c + 32 + 1));

        //删除字符串中出现次数最少的字符
        HashMap<Character, Integer> map = new HashMap<>();
        String s4 = "aboded";
        char[] chars = s4.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, (map.getOrDefault(aChar, 0) + 1));
        }

        Collection<Integer> values = map.values();
        Integer min = Collections.min(values);

        for (Character character : map.keySet()) {
            if (map.get(character).equals(min)) {
                s4 = s4.replace(String.valueOf(character), "");
            }
        }
        System.out.println(s4);

        //对字符串中的所有单词进行倒排,字母为a-z和A-Z
        String s6 = "$bo*y gi!r#l";
        String s5 = "I am a student";
        //正则匹配非字母的字符用来切割
        String[] words = s5.split("[^A-Za-z]");
        StringBuilder result1 = new StringBuilder();

        // 逆序添加分割完的单词
        for (int i = words.length - 1; i >= 0; i--) {
            result1.append(words[i]).append(" ");
        }
        System.out.println(result1.toString().trim());

        //字母图片排序整理,字母为a-z和A-Z,从小到大排序输出
        String s7 = "Ihave1nose2hands10fingers";
        char[] chars1 = s7.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char c1 : chars1) {
            characters.add(c1);
        }

        Collections.sort(characters);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characters) {
            stringBuilder.append(character);
        }
        System.out.println(stringBuilder);

        //打印蛇形矩阵
        int n = 5;
        //建立数组（n行）
        int[][] result2 = new int[n][];
        //记录依次赋予的数组值
        int t = 1;
        for (int i = 0; i < n; i++) {
            //数组第i行有n-i个元素
            result2[i] = new int[n - i];
            //对第i个对角线赋值
            for (int j = 0; j < i + 1; j++) {
                result2[i - j][j] = t;
                t++;
            }
        }
        //输出数组值
        for (int[] a : result2) {
            for (int a1 : a) {
                System.out.print(a1 + " ");
            }
            System.out.println();
        }

        //斐波那契数列, 每一项都等于前两项的和
        int m = 5;
        System.out.println(f(m));

        //统计每一个类型的字符数量
        String s8 = "1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\\\/;p0-=\\\\][\n";
        String s9 = s8.replaceAll("[A-Z]+|[a-z]+", "");
        System.out.println(s8.length() - s9.length());

        String s10 = s9.replaceAll(" ", "");
        System.out.println(s9.length() - s10.length());
        String s11 = s10.replaceAll("[0-9]+", "");
        System.out.println(s10.length() - s11.length() + "\n" + s11.length());

        //求一个数不包含自身的因数之和
        int nu = 28;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nu; i++) {
            if (nu % i == 0) {
                list.add(i);
            }
        }
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());

        // 判断是否素数（质数）,除了1和自身，不能被其他数整除
        int nn = 3;
        for (int i = 2; i <= Math.sqrt(nn); i++) {
            if (nn % i == 0) {
                System.out.println(false);
            }
        }
        System.out.println(true);
        System.out.println(Math.abs(-2));

        //一年当中第几天
        int y = 2024;
        int m1 = 4;
        int d = 3;
        Calendar c1 = Calendar.getInstance();
        //注意月份从0开始
        c1.set(y, m1 - 1, d);
        System.out.println(c1.get(Calendar.DAY_OF_YEAR));
        LocalDate date = LocalDate.of(2024, 4, 3);
        System.out.println(date.getDayOfYear());

        //闰年，被4整除不被100整除，或被400整除
        if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
            System.out.println(true);
        }

        //计算立方
        long sum = (long) Math.pow(n, 3);
        System.out.println(sum);

        //=======  输出最长回文子串  ========
        String s12 = "cdabbacc";
        int max = 0;
        String s13 = "";
        /**
         *双指针遍历找到最长子串
         */
        for (int i = 0; i < s12.length(); i++) {
            for (int j = s12.length(); j > i; j--) {
                String toBeJuged = s12.substring(i, j);
                if (isPalindromeString(toBeJuged)) {
                    max = (j - i) > max ? j - i : max;
                    s13 = (j - i) == max ? toBeJuged : s13;
                }
            }
        }
        System.out.println(max + ":" + s13);

        int a = 200;
        String bs1 = Integer.toBinaryString(a);
        String[] strings1 = bs1.split("0");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }




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

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    /**
     * 判断一个字符串是否是回文字符串的方法
     */
    static boolean isPalindromeString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}