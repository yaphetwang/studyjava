package sometests.sort;

/**
 * 插入排序算法实现
 * @author Administrator
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = { 3, -1, -1, -8, 2, 1 };
        printArray(array);  
        insertSort(array);  
        printArray(array);  	

	}
	
	
	public static void insertSort(int[] array) {  
        if (array == null || array.length < 2) {  
            return;  
        }  
  
        for (int i = 1; i < array.length; i++) {  
            int currentValue = array[i];  
            int position = i;  
            for (int j = i - 1; j >= 0; j--) {  
                if (array[j] > currentValue) {  
                    array[j + 1] = array[j];  
                    position -= 1;  
                } else {  
                    break;  
                }  
            }  
  
            array[position] = currentValue;  
        }  
    }  
	
	public static void printArray(int[] array) {  
        System.out.print("{");  
        for (int i = 0; i < array.length; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        System.out.println("}");  
    }  

}