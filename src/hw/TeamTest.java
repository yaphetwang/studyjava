package hw;

import java.util.Arrays;

/**
 * @author wangyafei
 * @date 2024/4/24 17:31
 * @description  求最多可以派出多少只团队 - 华为OD统一考试(C卷)
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为 N，
 * 每个团队可以由 1 人或 2 人组成，且 1 个人只能参加 1 个团队，
 * <p>
 * 请计算出最多可以派出多少支符合要求的团队
 * <p>
 * 5
 * 3 1 5 7 9
 * 8
 * <p>
 * 第一行代表总人数，范围[1,500000]
 * <p>
 * 第二行数组代表每个人的能力，每个元素的取值范围为[1,500000],数组的大小范围[1,500000]
 * <p>
 * 第三行数值为团队要求的最低能力值，范围[1,500000]
 * <p>
 * 作者：code5bug
 * 链接：https://www.nowcoder.com/discuss/606229388694155264?sourceSSR=search
 * 来源：牛客网
 * <p>
 * 说明：
 * 3，5组成一队，1，7组成一队，9自己一个队，故而输出3
 */
public class TeamTest {

    public static void main(String[] args) {
        // 团队要求的最低能力值
        int bound = 9;
        int[] p = new int[]{3, 1, 5, 7, 9};

        //升序排序
        Arrays.sort(p);

        int teams = 0;

        int r = p.length - 1;
        int l = 0;

        while (l < r) {
            int rv = p[r];
            int lv = p[l];
            if (rv >= bound) {
                //一个人组队
                teams += 1;
                r--;
            } else if (rv + lv >= bound) {
                //两个人组队
                teams += 1;
                r--;
                l++;
            } else {
                //放弃小的
                l++;
            }
        }

        System.out.println(teams);
    }

}
