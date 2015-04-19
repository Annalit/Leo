//Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
//You may assume that the array is non-empty and the majority element always exist in the array.

public Class Solution{
    public int findElement(int[] array){
        HashMap map = new HashMap();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                int count = map.get(array[i])+1;
                map.put(array[i], count); 
            }else{
                map.put(array[i], 1);
            }     
        }
    
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = it.next();
            if(entry.getValue() > array.length/2){
                return entry.getKey();
            }
        }
    }
}

//You have an array is sorted and contains a majority element. 
//Give me an algorithm that runtime is O(1) to find that majority element.
//[2, 1, 2, 1, 1]
//[2, 1] [2, 1, 1]
//[2, 1] [2, 1] [1] lf=Null mid=Null rh=1
//[2, 1] [2, 1, 1] lf=Null mid+rh=1
//[2, 1, 2, 1, 1] lf+mid+rh = 1

int findElement(int[] A) {
    if(A.length == 1) {
        return A[0];
    } else if (A.length == 2) {
       if(A[0] == A[1]) {
           return A[0];
       } else {
           return;
       }
    }
    
    int left = findElement(leftPartOfArray);
    int right = findElement(rightPartOfArray);
    
    if (left == right) {
        return left;
    } else {
        int leftCount = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == left) {
                leftCount ++;
            }
        }
        if(leftCount > A.length / 2) {
            return leftCount;
        }
        //Do the same for right;
    }
}


public class Solution{
    public int findElement(int[] array){
        HashMap map = new HashMap();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                int count = map.get(array[i])+1;
                map.put(array[i], count); 
            }else{
                map.put(array[i], 1);
            }     
        }
    
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = it.next();
            if(entry.getValue() > array.length/2){
                return entry.getKey();
            }
        }
    }
}
