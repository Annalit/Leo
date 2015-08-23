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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        //use a stack to track the trace of the last root, when the current root
        // is null, then make current root to the pop(), when the current root and the stack are both empty, then it is the end.
        // 1. if the current root is null but stack is not, then we can assign
        //2. if the stack is not null but cur is not, it is still possible for the stack to have value in the future.
        // no need to be afraid that the root may lose track
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return res;
    }
}
// comments: better to define TreeNode cur = root, and then use cur; otherwise even the res is right, but we still lose the track
// of this tree
