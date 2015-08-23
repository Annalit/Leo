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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        //把所有的right节点全部存在一个stack里面，然后什么时候pop呢
        //当cur为空的时候！我们使cur = stack.pop()，重新循环就好了！
        //什么时候结束循环，stack为空，可是一开始就是空，但是这个时候的cur
        //不是空，所以应该是cur为空而且stack也为空的时候。
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()) {
            if (cur == null) {
                cur = s.pop();
            }
            res.add(cur.val);
            if (cur.right != null) {
                s.push(cur.right);
            }
            cur = cur.left;
        }
        return res;
    }
}
