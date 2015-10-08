这里首先用course schedual的方法看整个图有没有环，
然后用res储存遍历每一个点的时候的count，最后看有没有一个点的count有length；
public class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public boolean validTree(int n, int[][] edges) {
        int[][] relation = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            relation[edges[i][0]][edges[i][1]] = 1;
            relation[edges[i][1]][edges[i][0]] = 1;
        }
        int[] visit = new int[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(relation, visit, i, -1, i)) {
                return false;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == n) {
                return true;
            }
        }
        return false;
    }
    boolean dfs(int[][] relation, int[] visit, int cur, int pre, int root) {
        visit[cur] = 1;
        if (visit[cur] == -1) {
            return true;
        }
        for (int i = 0; i < relation.length; i++) {
            if (i == pre) {
                continue;
            }
            if (relation[cur][i] == 1) {
                if (visit[i] == 1) {
                    return false;
                }
                if (visit[i] == 0 && !dfs(relation,visit, i, cur, root)) {
                    return false;
                }
            }
        }
        visit[cur] = -1;
        if (root > res.size() - 1) {
            res.add(1);
        } else {
            res.set(root, res.get(root) + 1);
        }
        return true;
    }
}
