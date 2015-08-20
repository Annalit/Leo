第一遍写出来的代码。
public class Solution {
	public int nthUglyNumber(int n) {
		if (n <= 5) {
			return n;
		}
		Comparator<Long> compare_min = new CompareMin();
		PriorityQueue<Long> queue = new PriorityQueue<Long>(100,
				compare_min);
		long[] res = new long[3];
		res[0] = 3;
		res[1] = 4;
		res[2] = 5;
		n = n - 5;
		int a = 0;
		for (int j = 0; j < (n - 1) / 3 + 1; j++) {
			for (int i = 0; i < 3; i++) {
				if (n == 1407 ) {
					a = 8;
				}
				int b = a;
				long cur = res[i];
				long cur2 = 2 * cur;
				long cur3 = 3 * cur;
				long cur5 = 5 * cur;
				if (!queue.contains(cur2)) {
					queue.add(cur2);
				}
				if (!queue.contains(cur3)) {
					queue.add(cur3);
				}
				if (!queue.contains(cur5)) {
					queue.add(cur5);
				}
			}
			res[0] = queue.poll();
			res[1] = queue.poll();
			res[2] = queue.poll();
		}
		int index = (n - 1) % 3;
		return (int)(res[index]);
	}

	public class CompareMin implements Comparator<Long> {
		public int compare(Long cur, Long parent) {
			return cur.compareTo(parent);
		}
	}
	其实这题第一遍没有想的特别清楚，因为其实这题是按照BFS来生成下一个数，所以生成的这个过程是可以用queue的，不过因为这道题只需要nth
	，不需要保存所有的过去节点，所以不用那么死板的用queue来BFS。
	重点在于生成的第n个数并不是按照BFS从左到右去获得， 而是所有queue里面在first后面所有节点中得到一个最大数，我们总是需要一个最大数，
	所以可以考虑把整个queue放到priorityqueue里面去维护，然后这样我们就可以按照大小顺序来取出里面的数，而不是按照放入顺序。
	所以这道题为什么用prioriyqueue，是因为我选择的优先条件是大小而不是顺序，其次是因为，这题确实可以用queue来实现BFS的。
	然后每次要返回的数其实就是queue.poll啦，顺便可以poll掉，因为每次需要的就是堆顶的元素。
	其实这道题本质就是一个按照大小来遍历的BFS。。
	然后改成了这样：
	public class Solution {
	public int nthUglyNumber(int n) {
		Comparator<Long> compare_min = new CompareMin();
		PriorityQueue<Long> queue = new PriorityQueue<Long>(100,
				compare_min);
		int res = 0;
		queue.add((long)1);
		queue.add((long)2);
		queue.add((long)3);
		queue.add((long)5);
		for (int i = 0; i < n; i++) {
				long cur = queue.peek();
				long cur2 = 2 * cur;
				long cur3 = 3 * cur;
				long cur5 = 5 * cur;
				if (!queue.contains(cur2)) {
					queue.add(cur2);
				}
				if (!queue.contains(cur3)) {
					queue.add(cur3);
				}
				if (!queue.contains(cur5)) {
					queue.add(cur5);
				}
				res = queue.poll().intValue();
			}
		return res;
		}

	class CompareMin implements Comparator<Long> {
		public int compare(Long cur, Long parent) {
			return cur.compareTo(parent);
		}
	}
}
但是这样写的话其实复杂度是n方的，因为queue里面的判断contain其实是On的，所以用一个hashset来优化会更好。
public class Solution {
	public int nthUglyNumber(int n) {
		Comparator<Long> compare_min = new CompareMin();
		PriorityQueue<Long> queue = new PriorityQueue<Long>(100,
				compare_min);
		int res = 0;
		queue.add((long)1);
		queue.add((long)2);
		queue.add((long)3);
		queue.add((long)5);
		HashSet<Long> hs = new HashSet<Long>();
	    hs.add((long)1);
		hs.add((long)2);
		hs.add((long)3);
		hs.add((long)5);
		for (int i = 0; i < n; i++) {
				long cur = queue.peek();
				long cur2 = 2 * cur;
				long cur3 = 3 * cur;
				long cur5 = 5 * cur;
				if (!hs.contains(cur2)) {
					queue.add(cur2);
					hs.add(cur2);
				}
				if (!hs.contains(cur3)) {
					queue.add(cur3);
					hs.add(cur3);
				}
				if (!hs.contains(cur5)) {
					queue.add(cur5);
					hs.add(cur5);
				}
				res = queue.poll().intValue();
			}
		return res;
		}

	class CompareMin implements Comparator<Long> {
		public int compare(Long cur, Long parent) {
			return cur.compareTo(parent);
		}
	}
}
