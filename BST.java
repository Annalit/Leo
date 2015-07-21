 void deleteBST(TreeNode root, int extra){
        delete(root, null, extra);
    }
    void delete(TreeNode root, TreeNode parent, int extra){
           // actually we can solve it recursivly, because once we delete the next node, we meet the same problem
           if (root.val > extra){
               delete(root.left, root, extra);
           } else if (root.val < extra){
               delete(root.right, root, extra);
           } else {
               //1. if the root has no subtree;
               if(root.right == null && root.left == null){
                   parent.right == root? parent.right = null: parent.left = null;
               } // 2. if the root has left subtree;
               else if (root.right == null){
                   parent.right == root? parent.right = root.left: parent.left = root.left;
               } // 3. if the root has right subtree
               else if(root.left == null)               
                   parent.right == root? parent.right == root.right: parent.left = root.right;
               }// 4if the root has both subtree
               else{
                   TreeNode p = root.right;
                   TreeNode q = root;
                   if(p.left != null){
                       q = root.right;
                       p = p.left;
                   }
                   while (p.left != null){
                       q = q.left;
                       p = p.left; 
                   }
                   parent.right == root? parent.right.val = p.val: parent.left.val = p.val;
                   delete(p, q);
               }
            }
        }
    }
    不需要先去找节点，然后再去想怎么得到树的爸爸，这样想没有完全利用这个树的递归定义和问题的递归性质，
    之前的想法是，先去find这个节点，然后再remove，
    然后remove的时候又要去find节点。。
    然后你会发现其实find就是remove过程中不可或缺的一部分。
    所以helper的定义应该是，1，找到要remove的节点，2. remove它。
    反正没有找到就不删嘛。。。
    子问题啊子问题，你给子问题正确的参数让它去做就好了。
    我要删整个树的某个节点，我要删subtree的某个节点，我要删的就是这个节点！
