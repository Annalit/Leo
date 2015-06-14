public class Solution {
    public int countPrimes(int n) {
    Boolean[] b = new Boolean[n];
    int count = 0;
    for(int i = 1; i< n; i++){
        b[i] = true;
    }
    for(int i =2;i*i< n;i++){
        if(b[i]){
        for(int j = i; j * i < n; j++){
                b[j * i] = false;
            }
        }
        
    }
    for(int i = 2; i < n; i++){
        if(b[i]){
            count++;
        }
    }
    return count;
    }
}
