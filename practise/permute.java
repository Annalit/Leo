public class Solution{
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] num){
        List<Integer> inner = new ArrayList<Integer>();
        helper(num,inner);
        return result;        
    }
    void helper(int[] s, List<Integer> inner){
        if(s.length == 0){
             result.add(inner);
        }
        for(int i = 0;i < s.length; i++){
            List<Integer> innertemp = new ArrayList<Integer>(inner);
            innertemp.add(s[i]);
            int[] t=new int[s.length-1];
            int count=0;
            for(int j=0;j < s.length; j++){
                if(j == i){
                    continue;
                }
                t[count]=s[j];
                count++;
            }
            helper(t, innertemp);    
        }

    }
}
void helper(int[] array, int curr) {
    if (curr == array.length) {
        // print this array on the screen
        // trivial code. I will omit here
    }
    for (int i = curr; i < array.length; ++i) {
        swap(array[curr], array[i]);
        helper(array, curr + 1);
        swap(array[curr], array[i]);
    }
}

void permutation(int[] array) {
    helper(array, 0);
}
the array is divided to 2 parts: sorted and unsorted
stil the same idea, left and right, the left part is the chosen part, the right part is the part to be chosen
the curr is the division point
actually the same idea, the for loop is still the right part, the size of the curr can be
