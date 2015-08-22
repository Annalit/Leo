Consider lines of slope -1 passing between nodes (dotted lines in below diagram). 
Diagonal sum in a binary tree is sum of all node’s data lying through these lines. 
Given a Binary Tree, print all diagonal sums. For the following input tree, output should be 11, 14, 5.
思路很简单。，不过出了一个bug。。
来我们再写一遍。
Iterator<TreeNode, Integer> its = hm.entrySet().next();
The Map.entrySet method returns a collection-view of the map
http://docs.oracle.com/javase/7/docs/api/java/util/Map.Entry.html
其实hm.entrySet
..这里错啦，应该是Iterator<Entry<TreeNode, Integer>>
while(its.hasNext()) {
  EntrySet<TreeNode Integer> temp = its.next();
  int val = temp.getVal();
  int key = temp.getKey();
}
注意和种类Entry<>是单个，entrySet()是返回一个集合啦

Set<Map.Entry<K,V>>	entrySet()
就是说Set<Entry<K,V>> entrySet()
所以其实map里面的类型就是Entry<K, V>,可以通过map.entrySet()得到。
public class Solution {
	public ArrayList<Integer> dotted(TreeNode root) {
		// we can try the inorder travesal first
		// so we need a hashmap to store the count for each node
		HashMap<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
		HashMap<Integer, Integer> cal = new HashMap<Integer, Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		inorder(root, hm, 0);
		Iterator<Entry<TreeNode, Integer>> its = hm.entrySet().iterator();
		while (its.hasNext()) {
			Entry<TreeNode, Integer> temp = its.next();
			int tempVal = temp.getKey().val;
			int tempKey = temp.getValue();
			if (!cal.containsKey(tempKey)) {
				cal.put(tempKey, tempVal);
			} else {
				cal.put(tempKey, cal.get(tempKey) + tempVal);
			}
		}
		ArrayList<Integer> index = new ArrayList<Integer>(cal.keySet());
		Collections.sort(index);
		for (int i = 0; i < index.size(); i++) {
			res.add(cal.get(index.get(i)));
		}
		return res;

	}

	void inorder(TreeNode root, HashMap<TreeNode, Integer> hm, int count) {
		if (root == null) {
			return;
		}
		inorder(root.left, hm, count + 1);
		hm.put(root, count);
		inorder(root.right, hm, count);
	}
