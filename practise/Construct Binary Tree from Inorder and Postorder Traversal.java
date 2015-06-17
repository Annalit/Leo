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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null
				|| postorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		int mid = getIndex(inorder, root.val);
		if(mid ==0&&mid ==inorder.length-1){
			return root;
		}
		int[] leftOfInorder = Arrays.copyOfRange(inorder, 0, mid);
		int[] rightOfInorder = Arrays.copyOfRange(inorder, mid + 1,
				inorder.length);
		int[] leftOfPostorder = Arrays.copyOfRange(postorder, 0, mid);
		int[] rightOfPostorder = Arrays.copyOfRange(postorder, postorder.length-1-(inorder.length-mid-1), postorder.length-1);
		root.left = buildTree(leftOfInorder,leftOfPostorder);
		root.right = buildTree(rightOfInorder,rightOfPostorder);
		return root;
	}

	int getIndex(int[] array, int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return i;
			}
		}
		return 0;
	}
}
