package hw;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author wangyafei
 * @date 2024/4/24 16:14
 * @description
 * 剩余银饰的重量 - 华为OD统一考试（C卷）
 *
 * 有N块二手市场收集的银饰，每块银饰的重量都是正整数，收集到的银饰会被熔化用于打造新的饰品。
 *
 * 每一回合，从中选出三块 最重的 银饰，然后一起熔掉。
 *
 * 假设银饰的重量分别为 x 、y和z，且 x <= y <= z。那么熔掉的可能结果如下：
 *
 * 如果 x == y == z，那么三块银饰都会被完全熔掉；
 * 如果 x == y 且 y != z，会剩余重量为 z - y 的银块无法被熔掉；
 * 如果 x != y 且 y == z，会剩余重量为 y - x 的银块无法被熔掉；
 * 如果 x != y 且 y != z，会剩余重量为 z - y 与 y - x 差值 的银块无法被熔掉。
 * 最后，如果剩余两块，返回较大的重量（若两块重量相同，返回任意一块皆可）；
 * 如果只剩下一块，返回该块的重量；如果没有剩下，就返回 0。
 *
 * 链接：https://www.nowcoder.com/discuss/594467008666746880
 */
public class SilverWeightTest {

    public static void main(String[] args) {

        //3个银块
        int n = 3;
        int[] w = new int[]{10, 7, 6};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(w[i]);
        }

        int count = 2;
        while (pq.size() > count) {
            int z = pq.poll();
            int y = pq.poll();
            int x = pq.poll();
            if (x == y && y == z) {
            } else if (x == y && y != z) {
                pq.offer(z - y);
            } else if (x != y && y == z) {
                pq.offer(y - x);
            } else if (x != y && y != z) {
                pq.offer(Math.abs((z - y) - (y - x)));
            }

        }

        if (pq.isEmpty()) {
            System.out.println(0);
        } else if (pq.size() == 1) {
            System.out.println(pq.peek());
        } else {
            System.out.println(Math.max(pq.peek(), pq.peek()));
        }
        System.out.println(pq.size());

    }

}
