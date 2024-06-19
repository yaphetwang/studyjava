package hw;

import java.util.*;

/**
 * @author wangyafei
 * @date 2024/6/18 16:55
 * @description 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * <p>
 * 滑动窗口 算法 经典讲解
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/9749/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/?envType=study-plan-v2&envId=top-100-liked
 */
public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";

        System.out.println(findAnagramsByArray(s, t));

        //使用map的方式
        System.out.println(findAnagrams(s, t));
    }

    public static List<Integer> findAnagramsByArray(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] need = new int[128];
        int[] window = new int[128];

        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
        }

        //valid字段用来比对数量
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    //匹配到一个
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()) {
                //这个地方需要 收集>0 的槽位数量
                //if (valid == Arrays.stream(need).filter(a -> a > 0).count()) {
                if (valid == p.length()) {
                    list.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        //匹配到一个
                        valid--;
                    }

                    window[d]--;
                }
            }
        }

        return list;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>(p.length());
        Map<Character, Integer> window = new HashMap<>(p.length());
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(cur)) {
                Integer total = window.getOrDefault(cur, 0) + 1;
                window.put(cur, total);
                if (window.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()) {
                // 当窗口符合条件时，把起始索引加入 result 中
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口数据当一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return result;
    }
}
