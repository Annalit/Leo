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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null||nums.length ==0)
            return null;
        int len = nums.length;
        int mid = len/2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] font = Arrays.copyOfRange(nums, 0, mid);
        int[] end = Arrays.copyOfRange(nums, mid+1, len);
        root.left = sortedArrayToBST(font);
        root.right = sortedArrayToBST(end);
        return root;
    }
}
