view的题目感觉基本上还是要用先序遍历来做，因为涉及到一个全局变量，当前root当前处理完应该是最好的。
当我们是rightView的时候，先序遍历满足一个到右下角。
topView的时候开始涉及一个left和right，left和right用先序遍历来改变是最好的。因为我如果用中序遍历，
访问到当前的时候就没有超过了啊-    -。
bottomView也应该是线序遍历，我想想。
public class Solution {
	int left = 0;
	int right = 0;
	public ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		//HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		inorder(root, 0, res);
		return res;
	}

	void inorder(TreeNode root, int count, ArrayList<Integer> res ) {
		if (root == null) {
			return;
		}// left: count --, right: count++;
		//inorder(root.left, count - 1, res);
		if (count < left || count > right|| (count == left && count == right)) {
			res.add(root.val);
			if (count < left) {
				left = count;
			} else {
				right = count;
			}
		}
		inorder(root.left, count - 1, res);
		inorder(root.right, count + 1, res);
	}

    public static void main(String args[]) {
		Solution s = new Solution();
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(1);
		TreeNode a9 = new TreeNode(1);
		TreeNode a10 = new TreeNode(1);
		TreeNode a11 = new TreeNode(1);
		TreeNode a12 = new TreeNode(1);
		a8.left = a10;
		a10.left = a11;
		a.left = b;
		a.right = c;
		a1.left = a2;
		a1.right = a3;
		a3.right = a7;
		a3.left = a6;
		a2.left = a4;
		a2.right = a5;
		a5.left = a8;
		a6.right = a9;
		System.out.print(s.topView(a1).toString());

	}
}
这样就可以实现逆序输出了。
public class Solution {
	int left = 0;
	int right = 0;
	int breakPoint = 0;
	public ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		//HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		inorder(root, 0, res);
		int s = 0; int e = breakPoint - 1; 
		while (s < e) {
			int temp = res.get(s);
			res.set(s, res.get(e));
			res.set(e, temp);
			s++;
			e--;
		} 
		return res;
	}

	void inorder(TreeNode root, int count, ArrayList<Integer> res ) {
		if (root == null) {
			return;
		}// left: count --, right: count++;
		//inorder(root.left, count - 1, res);
		if (right == 1) {
			breakPoint = res.size() - 1;
		}
		if (count < left || count > right|| (count == left && count == right)) {
			res.add(root.val);
			if (count < left) {
				left = count;
			} else {
				right = count;
			}
		}
		inorder(root.left, count - 1, res);
		inorder(root.right, count + 1, res);
	}
// bottom view
public Pair(int x, int y) {
	this.x = x;
	this.y = y;
}
public class Solution {
	int breakPoint = 0;
	public ArrayList<Integer> bottomView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();// left to int
		HashSet<Pair> hs = new HashSet<Pair>();
		inorder(root, 0,0, hm, hs);
		ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hm.keySet());
		Collections.sort(sortedKeys);
		for (int i:sortedKeys){
			for (int j: hm.get(i))
			res.add(j);
		}
		return res;
	}

	void inorder(TreeNode root, int x, int y, HashMap<Integer, ArrayList<Integer>> hm, HashSet<Pair> hs) {
		if (root == null) {
			return;
		}
		Pair cur = new Pair(x, y);
		if (hs.contains(cur)) {
			ArrayList<Integer> temp = hm.get(x);
			temp.add(root.val);
			hm.put(x, temp);
		} else {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(root.val);
			hm.put(x, temp);
			hs.add(cur);
		}
		inorder(root.left, x - 1, y + 1, hm, hs);
		inorder(root.right, x + 1, y + 1, hm, hs);
	}
