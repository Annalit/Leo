/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); //important
            for(int i = 0; i < size; i++){
                TreeLinkNode temp = q.poll();
                if(i<size-1){
                    temp.next = q.peek();
                } else {
                    temp.next = null;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }
}
