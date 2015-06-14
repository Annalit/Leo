/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> outer = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null)
            return outer;
        Boolean shift = true;// 0 is left;
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> inner = new ArrayList<Integer>();
            int size = q.size(); 
            for(int i = 0; i < size; i++){
                root = q.poll();
                inner.add(root.val);
                    if(root.left!=null){
                        q.add(root.left);
                    }
                    if(root.right!=null){
                        q.add(root.right);
                    }
            }
            if(!shift){
                Collections.reverse(inner);
            }
            outer.add(inner);
            shift = !(shift);
        }
        return outer;
        }
}
