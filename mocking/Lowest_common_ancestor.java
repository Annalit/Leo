//https://en.wikipedia.org/wiki/Lowest_common_ancestor#/media/File:Lowest_common_ancestor.svg
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode father;
}

//Given a binary tree, find the lowest common ancestor of two given nodes in the tree. 
//Each node contains a parent pointer which links to its parent.
   public TreeNode getAncester(TreeNode t1, TreeNode t2){
       HashSet<TreeNode> hs = new HashSet<TreeNode>();
       while(t1 != null || t2 != null){
           if(hs.contains(t1)){
               return t1;
           }
           if(hs.contains(t2)){
               return t2;
           }
           hs.add(t1);
           hs.add(t2);
           if(t1!=null){
               t1 = t1.father;
           }
           if(t2!=null){
               t2 = t2.father;
           }
       }
       return null;    
   }
   
   public TreeNode getA(TreeNode t1, TreeNode t2){
       int h1 = 0;
       int h2 = 0;
       int d = 0;
       TreeNode x1 = t1;
       TreeNode x2 = t2;
       h1 = getHeight(x1);
       h2 = getHeight(x2);
       d = Math.abs(h1-h2);
       if ((h1 - h2) < 0) {
           return getA(t2, t1); 
       }
       while(d!=0){
           l = l.father;
           d--;
       }
       while(l!=null&&h!=null){
           if(l==h){
               return l;
           } 
           l = l.father;
           h = h.father;
       }
       else return null;
   }
   int getHeight(TreeNode x1){
       int h1 = 0;
       while(x1!=null){
           x1 = x1.father;
           h1++;
       }
       return h1;
   }
