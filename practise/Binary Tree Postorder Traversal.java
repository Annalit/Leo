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
}dddpublic class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     * 除了用hashset，我们会发现其实我们并不需要真的记录所有的节点。
     * 我们用hashset的本质是看从右边回来的时候，根节点是不是第二次访问。
     * 如果用一个last来表示它是很困难的，因为如果last记录根节点的话，
     * 走到右子树里面这个信息是可能会被丢失的。
     * 我peek这个元素的时候到底是不是第二次peek
     * 因为peek肯定是右子树访问完了然后peek，所以其实我们只要能确定root
     * 的右节点是否被访问过，或者说，root的有节点是否为空，我们就可以确定root
     * 是否需要被pop
     * 这里面其实一开始会担心在右子树里面遍历的时候会把last的信息给丢掉，
     * 但是这里last的赋值有没有规律呢。
     * 也就是一个节点被pop之后，赢让last指向这个节点
     * last永远指向我准备出栈时，栈顶元素的右孩子
     * 出栈之后，如果当前子树是左子树，last赋值其实无所谓，但是如果是右子树，last需要指向该pop()元素，
     * 因为其实last元素按照一种出栈顺序指向peek()元素的右孩子，其实postorder是一种从爸爸到孩子的压栈，那么每次右孩子
     * 可以pop出来的时候，
     * 说明父亲一定已经被peek()过一次，因为我们每次都是通过父节点来找右孩子，不然右孩子不会被压栈的对不对~
     * 所以每次root节点确定可以被pop的时候，它需要还原的last就是它本身。
     * 当然如果root节点是某个节点的左孩子，其实这个就无所谓了啦。
     * 为什么这里用last来存peek()的右孩子呢。要是存peek()本身来表示上次被访问的孩子呢
     * 哈哈那是因为如果存右孩子，我可以让last从孩子到父亲赋值
     * 但是如果是寸节点本身，我这个节点被pop之后，我的last怎么赋值才好呢，我需要指向它的parent呀~~~
     */
     
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode last = new TreeNode(-1);
        while (!s.isEmpty() || cur != null) {
            if (cur == null) {
                TreeNode temp = s.peek();
                if (temp.right == last || temp.right == null) {
                    res.add(temp.val);
                    last = temp;
                    s.pop();
                } else {
                    cur = temp.right;
                }
            } else {
                s.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}
// better to define TreeNode cur = root and then use cur instead.
