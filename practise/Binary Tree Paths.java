这题想了很久。。
不能用null来判断递归终止时刻，因为终止时刻对一个叶子节点来说其实有两次，那样的话会打印两次。
所以应该到叶子节点就是终止时刻了。
这只是一个思路问题
然后再就是往下走的时候，其实用 val + ->,因为除了length == 1和叶子节点的时候，所有节点都符合这个性质。
如果用 - > + val,根节点那里不好处理。
其实这道题的节点就应该只是是不是叶子节点，是叶子节点就是val， 不是叶子节点就是val + ->。
但是不是叶子节点又不能两个孩子全都加val + ->, 因为如果左孩子不存在，其实左边这条路就不用管了。
所以需要两个if来判断该方向的孩子是否存在。
特殊情况就是一个节点，根节点也是叶子节点，是符合我们的算法的。所以这个方法是非常合理的。
这题怎么想到用叶子节点分的，
因为到叶子节点就必须输出了，特殊情况下只有一个节点，此时是val，如果是正确的算法， 叶子也都应该是val
public class Solution {
    ArrayList<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(sb, 0, root);
        return res;
    }
    void helper(StringBuffer sb, int lastlen, TreeNode root) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
        	sb.append(root.val + "->");
            helper(sb, sb.length(), root.left);
            sb.delete(lastlen, sb.length());
        }
        if (root.right != null) {
        	sb.append(root.val + "->");
            helper(sb, sb.length(), root.right);
            sb.delete(lastlen, sb.length());
        }
    }
}
