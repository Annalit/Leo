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
    TreeNode p = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(p == null){
            p = root;
        } else{
           if(p.val > root.val){
               if(first == null){
                   first = p;
               }
               second = root;
           }
           p = root;
        }
        inorder(root.right);
    }
}
