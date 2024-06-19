package hw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangyafei
 * @date 2024/6/12 22:10
 * @description 无重复字符的 连续最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 看这个大牛的算法递进
 * https://leetcode.cn/problems/wtcaE1/solutions/974092/jian-dan-yi-dong-javac-pythonjshua-dong-dtang/
 */
public class MaxNoRepeatString {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "abcdee";
        System.out.println(maxNoRepeatStringByHashSet(s2));
        System.out.println(maxNoRepeatStringByMap(s2));
        System.out.println(maxNoRepeatStringByArray(s2));
        System.out.println(maxNoRepeatStringByArrayJump(s2));
    }

    /**
     * 暴力解法就是 双指针 取出所有的子串 判断是否有重复的，没有重复的就比较长度
     * 比较耗时
     * 判断重复：使用set存放一下
     * @param s
     * @return
     */

    /**
     * 滑动窗口 + HashSet
     *
     * @param s
     * @return
     */
    public static int maxNoRepeatStringByHashSet(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }

        Set<Character> set = new HashSet<>(s.length());

        for (int left = 0, right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                //说明存在重复的，窗口收缩，去掉左边的
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            //每次更新最大值
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /**
     * 滑动窗口 + Map
     *
     * @param s
     * @return
     */
    public static int maxNoRepeatStringByMap(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }

        Map<Character, Integer> map = new HashMap<>(s.length());

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                // >1 说明存在重复的
                char r = s.charAt(left++);
                //窗口收缩，去掉左边的
                map.put(r, map.get(r) - 1);
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /**
     * 滑动窗口 + Array
     *
     * @param s
     * @return
     */
    public static int maxNoRepeatStringByArray(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }

        int[] arr = new int[128];

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            arr[c]++;

            while (arr[c] > 1) {
                // >1 说明存在重复的
                char r = s.charAt(left++);
                //窗口收缩，去掉左边的
                arr[r]--;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    //以上当在窗口中存在重复字符，是一个一个字符的缩小窗口~
    //我们可以通过记住每个字符在字符串中的索引，当遇到重复字符的时候，就可以直接跳到重复字符的后面

    /**
     * 滑动窗口 + Array (HashMap) + 跳跃
     *
     * @param s
     * @return
     */
    public static int maxNoRepeatStringByArrayJump(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }

        int[] arr = new int[128];

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int cIndex = arr[c];

            left = Math.max(left, cIndex);

            max = Math.max(max, right - left + 1);
            arr[c] = right + 1;
        }

        return max;
    }

}