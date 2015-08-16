2.Given an array of integers. Find two disjoint contiguous subarrays in it such that the absolute value of the difference between the sums of two subarray is maximum. Return the maximum difference. For example:
Array: {1, -3, 1, -4, 3, 4}
Result subarrays: {-3, 1, -4}, {3, 4}
Maximum difference = 13




public class Solution {
	public int bigDif(int[] arr) {
    	int len = arr.length;
    	int[] preMin = new int[len];
	    int[] preMax = new int[len];
	    int[] posMin = new int[len];
	    int[] posMax = new int[len];
	    preMin[0] = arr[0];
	    preMax[0] = arr[0];
	    posMin[len - 1] = arr[len - 1];
	    posMax[len - 1] = arr[len - 1];

    	int max = Integer.MIN_VALUE;
    	for (int i = 1; i < len; i++) {
    	preMax[i] = Math.max(preMax[i - 1] + arr[i], arr[i]);
	    preMin[i] = Math.min(preMin[i - 1] + arr[i], arr[i]);
	    }
	    for (int i = len - 2; i >= 0; i--) {
	    	posMax[i] = Math.max(posMax[i + 1] + arr[i], arr[i]);
	    	posMin[i] = Math.min(posMin[i + 1] + arr[i], arr[i]);
	    }
	    for (int i = 0; i < len - 1; i++) {
	    	max = Math.max(max, Math.max(preMax[i] - posMin[i + 1], posMax[i + 1] - preMin[i]));
	    }
	    return max;
    }
    下面这个方法好像有bug。。但是思路应该没有大问题。
    public class Solution {
	public int bigDiff(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		int len = arr.length;
		int res = Integer.MIN_VALUE;
		int[] sum = new int[len];
		sum[0] = arr[0];
		Comparator<Integer> max_comparator = new CompareMax();
		Comparator<Integer> min_comparator = new CompareMin();
		PriorityQueue<Integer> leftmax = new PriorityQueue<Integer>(len,
				max_comparator);
		PriorityQueue<Integer> rightmax = new PriorityQueue<Integer>(len,
				max_comparator);
		PriorityQueue<Integer> leftmin = new PriorityQueue<Integer>(len,
				min_comparator);
		PriorityQueue<Integer> rightmin = new PriorityQueue<Integer>(len,
				min_comparator);
		// add right to right queue
		for (int i = 1; i < len; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		for (int i = 0; i < len; i++) {
			int cur = arr[i];
			rightmax.add(cur);
			rightmin.add(cur);
		}
		for (int i = 0; i < len; i++) {
			int cur = arr[i];
			leftmax.add(cur);
			leftmin.add(cur);
			int premax = leftmax.peek();
			int premin = leftmin.peek();
			if (rightmax.peek() == cur) {
				rightmax.poll();
			}
			if (rightmin.peek() == cur) {
				rightmin.poll();
			}
			int posmax = rightmax.peek();
			int posmin = rightmin.peek();
			int left1 = sum[cur] - sum[premax] + arr[premax];
			int left2 = sum[cur] - sum[premin] + arr[premin];
			int right1 = sum[posmax] - sum[cur];
			int right2 = sum[posmin] - sum[cur];
			int ans1 = Math.abs(right1 - left1);
			int ans2 = Math.abs(right1 - left2);
			int ans3 = Math.abs(right2 - left1);
			int ans4 = Math.abs(right2 - left2);
			int temp = Math.max(ans1, Math.max(ans2, Math.max(ans3, ans4)));
			res = Math.max(res, temp);
		}
		return res;
	}
