public class Solution {
	public TreeNode invertTree(TreeNode root)
	{
		if (root==null)
		{
			return null;
		}
		TreeNode temp=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(temp);
		return root;
	}
	//exchange the left subtree and right subtree
	1. For the current node, exchange the left child and right child.
	2. For the left child, do it.
	3. For the right child, do it.
	you know how to exchange, right?
}
