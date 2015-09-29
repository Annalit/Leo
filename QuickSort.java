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
而且如果停下来等坑的时候发现没坑了，i和j就碰面了，说明本来这里就应该是分界点了。
i和j并不是同时，那么必定有一个先到分界点，那么这个点毕竟能进它该进的坑。
思路就是，我一旦有一个点，它不在它该在的位置，那么必定已经存在一个坑让它放进去！
因为每次交换后其实i和j都留在坑那个地方啊啊啊，所以每一步之前都互相有坑的！
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
这个下面是用多线程写的快排。。QuickSorter left = new QuickSorter(numbers, start, pivot,threshold);这个地方不能用pivot - 1..不深究
了。。出来了就行了。。反正也会忘
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.*;
import java.util.*;

public class QuickSorter extends RecursiveAction {
	int[] numbers;
	int start;
	int end;
	int threshold;

	public QuickSorter(int[] nums, int start, int end, int threshold) {
		numbers = nums;
		this.start = start;
		this.end = end;
		this.threshold = threshold;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		if (end - start < threshold) {
			Arrays.sort(numbers, start, end + 1);
			return;
		}
		int pivot = partition(numbers, start, end);
		QuickSorter left = new QuickSorter(numbers, start, pivot,threshold);
		QuickSorter right = new QuickSorter(numbers, pivot + 1, end,threshold);
		left.fork();
		right.compute();
		left.join();
	}

	public int partition(int[] n, int left, int right) {
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

	public static void main(String args[]) {
		FileInputStream file = null;
		Scanner scanner = null;
		/* The method below is complete. */
			try {
				file = new FileInputStream(args[0]);
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int threshold = new Integer(args[1]);
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (scanner.hasNext()) {
			res.add(scanner.nextInt());
		}
		int[] nums = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			nums[i] = res.get(i);
		}
		ForkJoinPool f = new ForkJoinPool();
		f.invoke(new QuickSorter(nums, 0, res.size() - 1,threshold));
		System.out.print(Arrays.toString(nums));
	}
}
