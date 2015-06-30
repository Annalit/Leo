public class Solution {
    public int jump(int[] nums) {
        Queue<Integer> q = new LinkedList<Integer>();
        Boolean flag = false;
        int len = nums.length;
        int count = 0;
        q.add(0);
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int j = 0; j < size; j++){
                int temp = q.poll();//index;
                int cur_breadth = nums[temp] + temp;
                if(cur_breadth >= len - 1){
                    flag = true;
                    break;
                } 
                for(int i = temp + 1; i < cur_breadth; i++){
                    if(nums[i] + i > cur_breadth){
                        q.add(i);
                    }
                }
            }
            if(flag)
                break;
        }
        return count;
    }
}
