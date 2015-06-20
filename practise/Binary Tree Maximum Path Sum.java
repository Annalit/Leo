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
        int left = helper(root.left); // for the max number
        int right = helper(root.right); // for the max number
        int cur = root.val + (left>0?left:0)+(right>0?right:0);
        if(cur>res)
            res = cur; //the max number so far
        return root.val+Math.max(left, Math.max(right,0));// but return either root+left or root+ right;
    }
}
