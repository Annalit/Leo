Kth Smallest Number in Sorted Matrix过了，好像也没有多复杂，不过我发现priorityqueue要经常注意重复，不能加重复的数进去，当然如果pair本身不等，只是优先度相等，这个是允许的。
然后就是这道题写hashset因为是自定义的类，所以要给它设计hashcode和equal方法。
研究一下怎么写hashcode和equal，难道必须按照eclipse里面自动生成的那种方法来么。
刚刚发现其实这样写就可以了：
class Pair{
    @Override
	public int hashCode() {
		return row * col;
	}
	@Override
	public boolean equals(Object obj) {
		Pair other = (Pair)(obj);
		return this.row == other.row && this.col == other.col;
	}
	int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
重点是这两个一定要一起写，
因为只写hashcode不写equal肯定不准确，除非字符串那种，一般你很难真的用hashcode来代替equal
只写equal不写hashcode肯定错。。因为object默认的hashcode是一个object一个distinc码。。hashcode不等的话根本到不了equal那里去。。
http://www.programcreek.com/2013/09/java-hashcode-equals-contract-set-contains/
上面这个链接写的很好
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
	   public int kthSmallest(int[][] matrix, int k) {
	        if (matrix == null || matrix.length == 0) {
	            return -1;
	        }
	        Comparator<Pair> Compare_Min = new CompareMin(matrix);
	        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(100, Compare_Min);
	        HashSet<Pair> hs = new HashSet<Pair>();
	        Pair cur = new Pair(0,0);
	        queue.add(cur);
	        hs.add(cur);
	        int x = matrix[0].length;
	        int y = matrix.length;
	        // we need to consider whether k is valid later
	        for (int i = 0; i < k; i++) {
	            cur = queue.poll();
	            int row = cur.row;
	            int col = cur.col;
	            //System.out.println(col+ "  "+row);
	            Pair down = new Pair(row + 1, col);
	            Pair right = new Pair(row, col + 1);
	            if (!hs.contains(down) && row + 1 < y) {
	            	queue.add(down);
	            	hs.add(down);
	            }
	            if (!hs.contains(right) && col + 1 < x) { 
	            	queue.add(right);
	            	hs.add(right);
	            }
	        }
	        return matrix[cur.row][cur.col];
	    }
}
class Pair{
    int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}
class CompareMin implements Comparator<Pair>{
    int[][] arr;
    public CompareMin(int[][] arr) {
        this.arr = arr;
    }
    public int compare (Pair cur, Pair parent) {
        if (arr[cur.row][cur.col] - (arr[parent.row][parent.col]) >= 0) {
            return 1;
        } else 
            return -1;
    }
}
