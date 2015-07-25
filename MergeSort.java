第一次写mergesort, 因为以前总是觉得先分后至的方法很奇怪，难道说每次都先分成n个数组放到ArrayList里面然后两两合并么。
不是的。
其实又忘了递归的初衷。。因为害怕没有静下心来好好分析呢。。
其实对于一个s到end的数组。
我们想的是，s到mid的数组已经有序，mid + 1到 end的数组已经有序。然后我就可以把数组的这两段merge了。

其实这句话是说
mergesort(arr, s, mid);
mergesort(arr, mid + 1, e);
merge(arr, s, mid, e);
所以递归的是mergesort，就是每次都让一段有序。。每一次都会借助merge（因为真正完成这个功能的是merge）。
然后对于子数组，我又需要它的两个subarray有序。
递归下去。最后当一个array只有一个元素的时候，显然有序，然后返回该有序数组。
就是每次需要两个有序的subarray，然后return一个合并之后的有序的subarray。所以每次需要借助merge一次来合并两个有序的subarray。

public class Solution {
	public int[] getMergeSort(int[] arr) {
		mergesort(arr, 0, arr.length - 1);
		return arr;
		
	}
	public void mergesort(int[] arr, int s, int e){//让arr在s到e的这一段有序。
		if (e == s) {
	    	return;
	    } else {
	        int mid = s + (e - s) / 2;
	        mergesort(arr, s, mid);
	        mergesort(arr, mid + 1, e);
	        merge(arr, s, mid, e);
	    }
	}
	public void merge(int[] arr, int s, int mid, int e) {
	    int p = s, q = mid + 1;
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    while (p <= mid && q <= e) {
	        if (arr[p] <= arr[q]) {
	            res.add(arr[p]);
	            p++;
	        } else {
	            res.add(arr[q]);
	            q++;
	        }
	    }
	    if(p != mid) {
	        while(q <=e) {
	            res.add(arr[q]);
	            q++;
	        }
	    } else {
	        while (p <= mid) {
	            res.add(arr[p]);
	            p++;
	        }
	    }
	    for (int i = s; i <= e; i++) {
	        arr[i] = res.get(i - s);
	    }
	    System.out.print(Arrays.toString(arr));
	    return;
	}
}
