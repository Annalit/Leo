public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length  = triangle.size();
        if(triangle == null||length ==0){
            return 0;
        }
        int[] res = new int[length];
        int min = triangle.get(0).get(0);//global
        
        for(int i = 0; i < triangle.get(length-1).size(); i++){
            res[i] = triangle.get(length-1).get(i);
        }
        for(int i = length-2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                res[j] = Math.min(res[j]+triangle.get(i).get(j), res[j+1]+triangle.get(i).get(j));
            }
        }
        return res[0];
    }
}
