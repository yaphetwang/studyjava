package sometests;

/**
 * @author wyf
 * @date 2019/9/16 20:44
 * @description 给定一个整数数组 nums,
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素）,返回其最大和。
 */
public class TestNum {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (n > 0) {
                n += nums[i];
            } else {
                n = nums[i];
            }
            if (sum < n) {
                sum = n;
            }
        }
        return sum;
    }
}