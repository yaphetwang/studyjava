package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyafei
 * @date 2022/2/15 3:18 下午
 * @description 给定一个数组，给定一个数字。返回数组中可以相加得到指定数字的两个索引。
 * 比如：给定nums = [2, 7, 11, 15], target = 9
 * 那么要返回 [0, 1]，因为2 + 7 = 9
 */
public class TwoSumTest {

    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 11, 15};
        int[] r = twoSum(a, 26);

        System.out.println(Arrays.toString(r));

    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(map);
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
