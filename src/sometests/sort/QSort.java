package sometests.sort;

/**
 * 快速排序
 */
public class QSort {

    public static void qSort(int data[], int left, int right) {

        // 从左边找的位置
        int ll = left;
        // 从右边找的位置
        int rr = right;
        // 取第一个作为基准数
        int base = data[left];

        //Sort

        // 1 2 3 4 5
        while (ll < rr) {
            // 从后面往前找到比基准数小的数进行对换
            while (ll < rr && data[rr] >= base) {
                rr--;
            }
            // 为了怕是 没找到
            if (ll < rr) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;
            }
            // 从前面往后面找比基准数大的进行对换
            // 上面值互换之后的ll++ 只是为了让下面的while循环少一次条件判断，
            while (ll < rr && data[ll] <= base) {
                ll++;
            }
            if (ll < rr) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                rr--;
            }
        }
        System.out.println("以Base=" + base + "的排序结果");
        print(data);
        // 以基准数分为3部分，左边的比之小，右边比之大 我们要做的就是一把这左边和右边分别进行快速排序
        if (ll > left) {
            qSort(data, left, ll - 1);
        }
        if (rr < right) {
            qSort(data, ll + 1, right);
        }
    }

    public static void print(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = {45, 28, 80, 90, 50, 16, 100, 10};
        qSort(data, 0, data.length - 1);
        print(data);

    }
}
