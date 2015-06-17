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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, 0);
    }
    int helper(TreeNode root, int inher){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return root.val + inher;
        }
        int temp = (root.val+ inher) * 10;
        return helper(root.left, temp)+helper(root.right, temp);
    }
}
