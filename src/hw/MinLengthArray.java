package hw;

/**
 * @author wangyafei
 * @date 2024/4/27 15:43
 * @description 长度最小的数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target
 * <p>
 * 找出该数组中满足其总和大于等于 target 的 长度最小的  连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 */
public class MinLengthArray {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};

        System.out.println(method1(target, nums));
        System.out.println(method2(target, nums));
    }

    /**
     * 暴力法
     */
    public static int method1(int target, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min > nums.length ? 0 : min;
    }

    /**
     * 滑动窗口法
     */
    public static int method2(int target, int[] nums) {
        int min = nums.length + 1;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return min > nums.length ? 0 : min;
    }

}
