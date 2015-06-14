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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> save = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return save;
        queue.add(root);
        while(!queue.isEmpty()){
            int q = queue.size();
            for(int i = 0; i < q;i++){
                root = queue.poll();
                if(root.right!=null){
                    queue.add(root.right);
                }
                if(root.left!=null){
                    queue.add(root.left);
                }
                if(i == 0){
                    save.add(root.val);
                } 
            }
        }
        return save;
        }
}
