public class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    void quickSort(int[] nums, int low, int high){
        if (nums == null || nums.length == 0){
            return;
        }
        if (low >= high){
            return;
        }
        int i = low, j = high;
        int pivot = nums[i];
        while (i < j){
            if (nums[j] >= pivot && i < j){
                j--;
            }
            nums[i] = nums[j];
            if (nums[i] <= pivot && i < j){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
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
