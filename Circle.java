public class Solution {
    Boolean flag = false;
    public boolean getCicle(String[] arr) {
        helper(arr, 0);
        return flag;
    }
    void helper(String[] arr, int curr) {
        if(flag) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            String p = arr[i];
            String q = arr[i + 1];
            if (p.charAt(p.length() - 1) != q.charAt(0)){
                break;
            }
        }
        String p = arr[len - 1];
        String q = arr[0];
        if (p.charAt(p.length() - 1) == q.charAt(0)){
            flag = true;
        }
        for (int i = curr; i < len; i++){           
            swap(arr, curr, i);//aba baa
            helper(arr, curr + 1);
            swap(arr, curr, i);
        }
    }
    void swap (String[] arr, int a, int b) {
    	String temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }
