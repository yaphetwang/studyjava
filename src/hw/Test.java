package hw;

import java.time.LocalDate;
import java.util.*;

/**
 * @author wangyafei
 * @date 2024/4/2 15:26
 * @description 空格的ASCII码值为32。
 * 数字0到9的ASCII码值分别为48到57。
 * 大写字母“A”到“Z”的ASCII码值分别为65到90。
 * 小写字母“a”到“z”的ASCII码值分别为97到122。
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

        //Arrays.sort(array); 数组字典排序
        String[] array = new String[5];
        //Arrays.sort(array);
        //Collections.sort(characters); //集合字典排序
        //Collections.min()
        //Collections.reverse();


        // 十进制转二进制
        int num1 = 42;
        String bs = Integer.toBinaryString(num1);
        System.out.println(bs);
        System.out.println(bs.length() - bs.replaceAll("1", "").length());
        //二进制转十进制
        System.out.println(Integer.parseInt(bs, 2));

        //字母ASCII码
        //在Java中，char 类型用于表示单一的16位字符，其值必须在\u0000到\uffff（0到65535）之间，可以表示大多数常用Unicode字符。
        //在标准ASCII码中，大写英文字母的ASCII值从65开始，到90结束，对应于字母A到Z。
        //小写英文字母的ASCII值则从97开始，到122结束，对应于字母a到z。数字0的ASCII值为48
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
        //绝对值
        System.out.println(Math.abs(-2));
        //开平方根
        System.out.println(Math.sqrt(2));

        //一年当中第几天
        int y = 2024;
        int m1 = 4;
        int d = 3;
        Calendar calendar = Calendar.getInstance();
        //注意月份从0开始
        calendar.set(y, m1 - 1, d);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //LocalDate实现
        LocalDate date = LocalDate.of(2024, 4, 3);
        System.out.println(date.getDayOfYear());

        //闰年，被4整除不被100整除，或被400整除
        if (n % 4 == 0 && n % 100 != 0 || n % 400 == 0) {
            System.out.println(true);
        }

        //计算立方
        long sum = (long) Math.pow(n, 3);
        System.out.println(sum);

        //===============  输出最长回文子串  ==================
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
        //查找两个字符串a，b中的最长公共子串， 同样使用上述回文子串方法 =======

        System.out.println("二进制中连续1的子串");
        int a = 200;
        String bs1 = Integer.toBinaryString(a);
        String[] strings1 = bs1.split("0");
        System.out.println(strings1.length);
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }

        //LinkedHashMap 按插入顺序排序
        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.forEach((key, value) -> {

        });
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {

        }

        //把所有的数字段提取出来，前后加上星号再放回去
        String s14 = "Jkdi234klowe09a3";
        System.out.println(s14.replaceAll("([0-9]+)", "*$1*"));

        System.out.println(String.format("%.1f", 199.7435435));

        //在字符串中找出连续最长的数字串
        String s15 = "abcd12345ed125ss123058789";
        String s16 = s15.replaceAll("([0-9]+)", "@$1@");
        System.out.println(s16);
        String[] strings2 = s16.split("@");
        String re = "";
        int maxLength = 0;
        for (int i = 0; i < strings2.length; i++) {
            if (strings2[i].matches("[0-9]+")) {
                String temp = strings2[i];
                if (temp.length() == maxLength) {
                    re = re + temp;
                }
                if (temp.length() > maxLength) {
                    re = temp;
                    maxLength = temp.length();
                }
            }
        }
        System.out.println(re + "," + maxLength);
        //或者利用非数字部分直接分割出 数字串数组
        String[] strings3 = s15.split("[^0-9]+");

        //等差数列求和
        //等差数列求和的公式主要有两种形式，
        // 一种是首项加末项的和乘以项数除以2，公式为：Sn=n(a1+an)/2 或 Sn=（a1+an）×n÷2。
        // 另一种是前n项和，公式为Sn=a1*n+[n*(n-1)*d]/2 或 Sn=[n*(a1+an)]/2

        //求最小公倍数
        int a1 = 4;
        int b1 = 35;
        //存储a的原始值，递归过程中使用。
        int c1 = a1;
        System.out.println(gcb(a1, b1, c1));

        //DNA序列，找固定长度子串GC出现次数最多的
        String s17 = "AAATCACGGAGAAACCAGGTCAGCTGTCTTTACCTCGC";
        //子串长度固定
        int nnn = 19;

        String result3 = "";
        int count = 0;
        for (int i = 0; i <= s17.length() - nnn; i++) {
            String tmp = s17.substring(i, i + nnn);
            //分母相同，只需要比较分子大小
            int countGC = countGC(tmp);
            if (countGC > count) {
                result3 = tmp;
                count = countGC;
            }
        }
        System.out.println(result3);

        //找出字符串中第一个只出现一次的字符
        //设置信号量
        int signal = 0;
        //读取输入内容
        String s18 = "asdfasdfo";
        //遍历输入内容
        for (int i = 0; i < s18.length(); i++) {
            //判断每个字符是否出现第二次，如果存在只有一次的，设置信号量signal为1；
            if (s18.indexOf(s18.charAt(i)) == s18.lastIndexOf(s18.charAt(i))) {
                System.out.print(s18.charAt(i));
                signal = 1;
                break;
            }
        }
        //如果信号量为零，证明不存在重复字符
        if (signal == 0) {
            System.out.println(-1);
        }

        // 特定几个字符开头，接一到两位数字
        // if (s.matches("[WASD][0-9]{1,2}")) {}

        //求小球落地5次后所经历的路程和第5次反弹的高度
        double high = 1.0;
        double fiveHigh = 0.0;
        double instance = high;
        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                instance = instance + high;
            }

            high = high / 2;

            if (i == 4) {
                fiveHigh = high;
            }
        }
        System.out.println(String.format("%.3f", instance));
        System.out.println(String.format("%.5f", fiveHigh));

        ThreadLocal local = new ThreadLocal();
        local.set("test");

        //名字字符串的最大漂亮度,每个字符有一个1-26的权重值
        String s19 = "lisi";
        int[] ss = new int[128];
        for (int j = 0; j < s19.length(); j++) {
            //巧妙使用字符 ASCII值 作为数组下标
            ss[s19.charAt(j)]++;
        }
        Arrays.sort(ss);
        int mul = 26, sum1 = 0;
        for (int j = ss.length - 1; j >= 0 && ss[j] > 0; j--) {
            sum1 += ss[j] * mul;
            mul--;
        }
        System.out.println(sum1);


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

    /**
     * 最小公倍数
     *
     * @param a
     * @param b
     * @param c c=a
     * @return
     */
    public static int gcb(int a, int b, int c) {
        //a累加过程中永远可以整除自身，所以可以整除b时就是最小公倍数！
        if (a % b == 0) {
            return a;
        }
        //a累加自身原始值，例如a=4。  a=4,8,12,16....
        return gcb(a + c, b, c);
    }

    public static int countGC(String tmp) {
        String s = tmp.replaceAll("G", "");
        String s1 = tmp.replaceAll("C", "");
        return (tmp.length() - s.length()) + (tmp.length() - s1.length());

        //return tmp.replaceAll("[^CG]","").length();
    }
}
