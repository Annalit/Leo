这题比较corner的地方是test case
如果有很多课，但是没有prerequisite要求的时候，其实把课顺序输出就好啦~
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = prerequisites.length;
        if (numCourses == 0 || len == 0) {
            int[] temp = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                temp[i] = i;
            }
            return temp;
        }
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);// no prequsite
            }
        }
        int numNoPre = queue.size();
        while(!queue.isEmpty()) {
            int top = queue.remove();
            res.add(top);
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if (numNoPre!= numCourses) {
            return new int[0];
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
