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
		//a11.left = a12;
		//a11.left = a12;
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
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
		int[] test = {1,0};
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

