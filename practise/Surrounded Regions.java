这题用queue挺一目了然的，queue里面放integer，取出来的时候用一点小技巧。
然后每次由一个当前结点找到它下一次需要入queue的节点.
至于对点的处理，到底应该是入queue前还是入queue之后。
首先我明年对queue的定义应该更明确一些，这个queue应该都是存放处理过的点，这样应该会比较快。
其实queue的目的只是保存一个节点顺序。
那么如果用stack呢，stack里面放integer。
接下来存放的应该是周围的某一个，

我感觉只是因为两个数据结构的不同所以pop出来的东西不一样，然后整个方向就不一样了。
其实用stack和用queue的代码没差的
public class Solution {
	// use a queue to do BFS
	private Stack<Integer> stack = new Stack<Integer>();
 
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
 
		int m = board.length;
		int n = board[0].length;
 
		// merge O's on left & right boarder
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
 
			if (board[i][n - 1] == 'O') {
				bfs(board, i, n - 1);
			}
		}
 
		// merge O's on top & bottom boarder
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				bfs(board, 0, j);
			}
 
			if (board[m - 1][j] == 'O') {
				bfs(board, m - 1, j);
			}
		}
 
		// process the board
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}
 
	private void bfs(char[][] board, int i, int j) {
		int n = board[0].length;
 
		// fill current first and then its neighbors
		fillCell(board, i, j);
 
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			int x = cur / n;
			int y = cur % n;
			fillCell(board, x - 1, y);
			fillCell(board, x + 1, y);
			fillCell(board, x, y - 1);
			fillCell(board, x, y + 1);
		}
	}
 
	private void fillCell(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
			return;
 
		// add current cell is queue & then process its neighbors in bfs
		stack.push(i * n + j);
		board[i][j] = '#';
	}
}

