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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        // 用一个栈去存上一个root，然后每次遍历的时候
        // 这题麻烦一点是因为我需要加入arrayList里面的元素并不是我要pop出来的元素，我只是通过它来找右边的元素。
        //但是又不能只存右边的元素，因为从右边的元素很难找到root，
        //会想一下在preorder里面，每次往下走的时候都会加入res，然后存当前的right
        //在inorder里面，每次往下走的时候都push当前元素，然后每次pop的时候
        //存入res，然后再走右边，重复就好。
        //但是在postorder里面，每次往下走push当前元素，每次我不能马上pop，我只
        //能通过peek()然后找它的右孩子，然后重复整个过程，右孩子走完了，然后再
        //pop(), 那么问题在于什么时候pop呢，因为左孩子结束时栈里面也是它，
        //右孩子结束时栈里面也是它，我需要判断一下这个节点是否是第二次访问，
        //因为右孩子也可能是空嘛。
        //至于什么时候存到res里面，其实应该是真正pop这个元素的时候，和inorder比较像，因为并不是走一步存一步，那自然就是pop的时候存嘛-   -
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        HashSet<TreeNode> hs = new HashSet<TreeNode>();
        while (root != null || !s.isEmpty()) {
            if (root == null) {
                root = s.peek();
                if (hs.contains(root)) {
                    res.add(s.pop().val);
                    root = null;
                } else {
                    hs.add(root);
                    root = root.right;
                }
            } else {
                s.push(root);
                root = root.left;
            }
        }
        return res;
    }
}
