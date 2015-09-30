图的遍历无外乎dfs和bfs两种
首先new一个hashmap来设定node和head的关系
dfs的时候我们只需要node和hashmap，然后在hashmap里面对val(node)进行操作其实就是对head的操作了。
从一个点开始，首先遍历它所有的neighbor
如果hashmap不包含这个neighbor，说明这个点尚未拷贝，
那么拷贝其值，然后加入到hashmap中
然后按这个aneighbor来走
如果hashmap包含这个neighbor，说明已经被拷贝过了。
然后这个node的neibor全部拷贝一遍。。
这个地方用hashmap的目的是什么？
有个点要注意，就是如果我一个点已经遍历过了，我是不用再去遍历一遍的。
因为深度优先本身，如果遍历过一个点，那么这个点已经遍历完了。
你只需要把这个点加到该加的neighbor里面去，而不需要去遍历它。
map这里就是来管遍历的！

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        dfs(hm, node);
        return head;
    }
    public void dfs(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node) {
        if (node == null) 
            return;
        for (UndirectedGraphNode aneighbor: node.neighbors) {
            if (!hm.containsKey(aneighbor)) {
                UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                hm.put(aneighbor, newneighbor);
                dfs(hm, aneighbor);
            }
        hm.get(node).neighbors.add(hm.get(aneighbor));
        }
    } 
}
