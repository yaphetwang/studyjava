package sometests.sort;

/**
 * 选择排序
 */
public class ChooseSort {

    public static void main(String[] args) {

        int[] intArr = {5, 6, 9, 2, 4, 3, 8};
        int[] intArrAfterSort = ChoseSort(intArr);
        for (int arrItem : intArrAfterSort) {
            System.out.print(arrItem + " ");
        }

    }


    static int[] ChoseSort(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            int lowIndex = i;

            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] < intArr[lowIndex]) {
                    lowIndex = j;
                }
            }

            //将当前第一个元素与它后面序列中的最小的一个元素交换，也就是将最小的元素放在最前端  
            int temp = intArr[i];
            intArr[i] = intArr[lowIndex];
            intArr[lowIndex] = temp;
        }

        return intArr;

    }


}