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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        long p =Long.MIN_VALUE;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root!=null||!s.isEmpty()){
            if(root!=null){
                s.push(root);
                root = root.left;
            } else {
                TreeNode temp = s.pop();
                if(p >= temp.val){
                    return false;
                } else{
                    root = temp.right;
                    p = temp.val;
                }
            }
        }
        return true;
    }
}
