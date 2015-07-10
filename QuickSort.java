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
            while (nums[j] >= pivot && i < j){
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= pivot && i < j){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
因为一开始的pivot已经被记录了。
while里面先把i挖坑，然后把j填进来，然后把j挖坑，把i移过去
这个地方好像又短路了，其实每次while结束，很明显地发现i都是个坑
这就是为什么最后可以直接填pivot。
至于刚刚在纠结的如果相遇的时候比pivot大什么的，其实不用想这个，因相遇的时候的点i走过了！这个点的值已经到了它该去的坑！
记住从右边开始啊。。。因为左边才有坑填右边的大数。
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
