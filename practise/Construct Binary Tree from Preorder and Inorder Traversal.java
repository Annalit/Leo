public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null
				|| inorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int mid = getIndex(inorder, preorder[0]);
		int leftend;
		int rightbegin;
		if(mid ==0&&mid ==inorder.length-1){
			return root;
		}
		int[] leftOfInorder = Arrays.copyOfRange(inorder, 0, mid);
		int[] rightOfInorder = Arrays.copyOfRange(inorder, mid + 1,
				inorder.length);
		int[] leftOfPreorder = Arrays.copyOfRange(preorder, 1, 1+mid);
		int[] rightOfPreorder = Arrays.copyOfRange(preorder, preorder.length-(inorder.length-mid-1),
				preorder.length);
		root.left = buildTree(leftOfPreorder,leftOfInorder);
		root.right = buildTree(rightOfPreorder,rightOfInorder);
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
