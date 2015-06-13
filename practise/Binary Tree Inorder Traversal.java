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
        0. to store the current tree
        1. go left, to the bottom
        2. every node would be the root of the tree
        3. if the left is not empty, store it in stack, it is the order how to get answer
        4  if the left is empty, stack.pop() to get the second node we want.(the way we pop, follows the left.)
        5. we want the node be left, mid and right.
        6. but for the current node, there is no left anymore
        7. so the next node should be its right.
        8. store the new tree.
        while(!s.isEmpty() || root!=null){
            if(root!=null)
            {
                s.push(root);
                root = root.left;
            }
            else{
            TreeNode temp = s.pop();// the result is alwasys the node I stored in stack.
            result.add(temp.val);
            root = temp.right;
            }  
        }
        return result;
    }
    
}
