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
这题的确有一个更好的思路，
2,  3,  5
4,  6,  10
    9,  15
8,  12, 20
        25
        
这个规律是这样的，每一行的值其实是这样得到的
2x,3x, 5x,那么当我取3x的时候，很明显2x肯定已经被取过，因为2x< 3x,
所以一定会有2x * 3 = 6x已经存在在堆里面，所以3x不用再乘以2了，同理5也是的，
当然不一定取了2x下一个一定取3x，而是说当我取了3x的时候，2x一定被取过！
我们能得出这个论断当且仅当一行都是2x,3x,5x的时候。也就是说我们需要把他们分成三列。
当我pop出的数在第3x的列的时候，我们不需要把它再乘以2，因为3x存在那么2x一定存在，2x一定被取出来过
而且2x*3一定已经存在在priorityqueue里面了。
我们不需要明显的列表，但是我们需要记录cur最后一次是乘以几得来的。其实可以用一个HashMap? 
但是那跟HashSet有什么区别啊，我总要额外空间的啊
我觉得比hashset用的额外空间还大一些。-     -
