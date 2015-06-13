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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode lastnode = null; 
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                s.push(root);
                root = root.left;
                } else {  
                    TreeNode peekroot = s.peek();
                    if(peekroot.right!=null && lastnode!= peekroot.right){
                        root = peekroot.right;
                    } else {
                        result.add(peekroot.val);
                        lastnode = s.pop();
                    }
            }
        }
        return result;
    }
}
