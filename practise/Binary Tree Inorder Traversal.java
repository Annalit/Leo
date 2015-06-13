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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        s.push(root);
        while(!s.isEmpty() || root!=null){
            if(root!=null)
            {
                s.push(root);
                root = root.left;
            }
            else{
            TreeNode temp = s.pop();
            result.add(temp.val);
            root = temp.right;
            }  
        }
        return result;
    }
    
}
