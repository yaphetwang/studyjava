package hw;

import java.util.Arrays;

/**
 * @author wangyafei
 * @date 2024/6/15 16:48
 * @description 华为技术二面
 * 给一个整数数组， 输出 这些整数拼接后的最小数字， 整数可能为多位数
 */
public class MinNum {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 5, 8, 29};
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        //内置函数排序
        // Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        quicksort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        System.out.println(res);
    }

    /**
     * 快排
     */
    public static void quicksort(String[] strs, int left, int right) {
        if (left < right) {
            int pos = partition(strs, left, right);
            quicksort(strs, left, pos - 1);
            quicksort(strs, pos + 1, right);
        }
    }

    public static int partition(String[] strs, int left, int right) {
        //tmp为基准值
        String tmp = strs[left];
        while (left < right) {
            while (left < right && (strs[right] + tmp)
                    .compareTo(tmp + strs[right]) >= 0) {
                //说明 strs[right] > tmp
                right--;
            }
            strs[left] = strs[right];

            while (left < right && (strs[left] + tmp)
                    .compareTo(tmp + strs[left]) <= 0) {
                left++;
            }
            strs[right] = strs[left];
        }
        strs[left] = tmp;
        return left;
    }
}
