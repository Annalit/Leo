/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 1. I just need to store the right.
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                result.add(root.val);
                if(root.right!=null){
                    s.push(root.right);
                }
                root = root.left;
            }
            else{
                root = s.pop();
            }
        }
        return result;
    }
}
