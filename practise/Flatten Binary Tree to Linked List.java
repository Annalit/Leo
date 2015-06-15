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
public void flatten(TreeNode root){
		while(root!=null){
			if(root.left!=null){
				TreeNode pre = root.left;
				while(pre.right!=null)
					pre = pre.right;
				pre.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 

public class Solution {
    public void flatten(TreeNode root) {
       if(root == null){
            return;
        }
        
        if(root.left != null){
            TreeNode rightNode = root.right;
            TreeNode leftNode = root.left;
            root.left = null;
            root.right = leftNode;
            TreeNode p = leftNode;
            while(p.right != null){
                p = p.right;
            }
            p.right = rightNode;
        }
        flatten(root.right);
        
    }
    
    
}
