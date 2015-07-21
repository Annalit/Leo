Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].  Assuming X might not be in the array.
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
