package sometests.sort;

/**
 * 快速排序
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr=new int[]{1,3,5,2,6,4,9,7,8};
		int left=3;
		int right=5;
		int[] arr1=quicksort(arr,left,right);
		for(int arr1Item:arr1){  
            System.out.print(arr1Item+" ");  
        }

	}
	
	static int[] quicksort(int[] n, int left, int right) {
		int dp;
		if(left < right) {
		    dp = partition(n, left, right);
			quicksort(n, left, dp - 1);
			quicksort(n, dp + 1, right);
			return n;
		}
		return null;
		
	}
	
	static int partition(int[] n, int left, int right) {
		int pivot = n[left];
		while(left < right) {
			while(left < right && n[right] >= pivot){
			    right--;
		    }
			if(left < right){
				n[left++] = n[right];
			}
			while(left < right && n[left] <= pivot){
				left++;
			}
			if(left < right){
				n[right--] = n[left];
			}
		}
		n[left] = pivot;
		return left;
	}


}
