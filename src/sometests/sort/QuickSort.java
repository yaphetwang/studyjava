package sometests.sort;

/**
 * @author wangyafei
 *
 * <p>
 * 快速排序
 * 快速排序采用的是分治思想，即在一个无序的序列中选取一个任意的基准元素pivot，
 * 利用pivot将待排序的序列分成两部分，前面部分元素均小于或等于基准元素，后面部分均大于或等于基准元素，
 * 然后采用递归的方法分别对前后两部分重复上述操作，直到将无序序列排列成有序序列。
 * <p>
 * https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95/369842#reference-1
 * <p>
 * <p>
 * 各种排序算法比较 时间空间复杂度
 * https://baijiahao.baidu.com/s?id=1777520301328082950&wfr=spider&for=pc
 * https://blog.csdn.net/Sword52888/article/details/134252267
 * https://zhuanlan.zhihu.com/p/23480279
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 6, 4, 9, 7, 8, 34, 45, 19};
        //不能变
        int left = 0;
        int right = arr.length - 1;
        quicksort(arr, left, right);
        for (int arr1Item : arr) {
            System.out.print(arr1Item + " ");
        }
    }

    static void quicksort(int[] n, int left, int right) {
        int dp;
        if (left < right) {
            //一次排序
            dp = partition(n, left, right);
            //递归，依次对左边部分和右边部分 分别进行相同逻辑的排序
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    /**
     * 将数组按基准值分成两部分
     */
    static int partition(int[] n, int left, int right) {
        //每一次比较的基准值 取第一个值
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot) {
                //大于基准值，往前走，直到找到一个小于基准值的
                right--;
            }
            if (left < right) {
                n[left] = n[right];
            }
            while (left < right && n[left] <= pivot) {
                //小于基准值，往后走，直到找到一个大于基准值的
                left++;
            }
            if (left < right) {
                n[right] = n[left];
            }
        }
        //直到 left==right 结束，将基准值赋值
        n[left] = pivot;
        return left;
    }
}
