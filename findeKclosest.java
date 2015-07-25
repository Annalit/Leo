Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].  Assuming X might not be in the array.
public class Solution {
	public ArrayList<Integer> getK(int[] res, int target, int k) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    int mid = getIndex(res, target, 0, res.length - 1);
	    int p = mid - 1;
	    int q = mid;
	    while(k > 0 && p > 0 && q < res.length - 1) {
	        int left = target - res[p];
	        int right = res[q] - target;
	        if (left < right) {
	            result.add(res[p]);
	            p--;
	        } else {
	            result.add(res[q]);
	            q++;
	        }
	        k--;
	    }
	    if (k==0) {
	        return result;
	    } else {
	        if(p == 0) {
	            while(k > 0 && q < res.length - 1) {
	                result.add(res[q]);
	                q++;
	            }
	        } else {
	            while(k >0 && p > 0) {
	                result.add(res[p]);
	                p--;
	            }
	        }
	        return result;
	    }
	}
	public int getIndex(int[] res, int target, int s, int e) {
	// if found, return the index of the first element >= target, else get the area and do it recursively until only one element
	    if (s > e) {
	        return -1;
	    } 
	    int mid = s + (e - s) / 2;
	    if (target > res[mid]) {
	        return getIndex(res, target, mid + 1, e);
	    } else {
	        int temp = getIndex(res, target, s, mid - 1);
	        if (temp!= -1) {
	            return temp;
	        } else {
	            return mid;
	        }
	    }
	} 
下面是第一次写的，不知道是什么鬼。。。
public class Solution{
    public ArrayList<Integer> getK(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = arr.length;
        int index =  appr(0, len - 1, arr, x);
        int p = Math.max(0, index - k + 1);
        int q = Math.min(len - 1, index + k);
        int count = q - p + 1 - k;
        if (arr[index] == x) {
        	count --;
        } 
        while (count > 0){
            int pre = arr[index] - arr[p];
            int post = arr[q] - arr[index];
            if (pre > post) {
                p++;
            } else {
                q--;
            }
            count--;
        }
        for (int i = p; i <= q; i++){
        	if (arr[i] == x){
        		continue;
        	}
            res.add(arr[i]);
        }
        return res;        
    }
    int appr(int s, int e, int[] arr, int x){
        int mid = s + (e - s) / 2;
        if (s == e){
            return s;
        }
        if(x == arr[mid]){
        	return mid;
        }
        if (x > arr[mid]) {
            return appr(mid + 1, e, arr, x);
        } else{
            return appr(s, mid, arr, x);
        }
    } 
