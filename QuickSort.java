public class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
	public static void quickSort(int[]n ,int left,int right){
		int pivot;
		if (left < right) {
			pivot = partition(n, left, right);
			quickSort(n, left, pivot - 1);
			quickSort(n, pivot + 1, right);
		}
	}
	
	public static int partition(int[]n ,int left,int right){
		int pivot = n[left];
		while (left < right) {
			while (left < right && n[right] >= pivot) 
			    --right;
			n[left] = n[right];
			while (left < right && n[left] <= pivot) 
			    ++left;
			n[right] = n[left];
		}
		n[left] = pivot;
		return left;
	}
}

public class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    void quickSort(int[] nums, int low, int high){
        if (nums == null || nums.length == 0)
            return;
        if (low >= high){
            return;
        }
        int mid = (low + high) / 2;
        int pivot = nums[mid];
        int i = low;
        int j = high;
        while (i < j){
            while (nums[i] < pivot){
                i++;
            }
            while (nums[j] > pivot){
                j--;
            }
            if (i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if(low < j)
        quickSort(nums, low, j);
        if(high > i)
        quickSort(nums, i, high);
    }
}
