public class Solution{
    int res = 0;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        res = root.val;
        helper(root);
        return res;
    }
private int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int cur = root.val + (left>0?left:0)+(right>0?right:0);
        if(cur>res)
            res = cur;
        return root.val+Math.max(left, Math.max(right,0));
    }
}
