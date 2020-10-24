package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 检测无向图是否有环
 */
public class test1 {

    private boolean[] marked;
    private boolean hasCyle;
    public boolean hasCycle(int[][] graph) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                set.add(graph[i][j]);
            }
        }
        // 顶点数
        int nodes = set.size();
        marked = new boolean[nodes];
        // 将图转为邻接矩阵
        List<Integer>[] adj = new ArrayList[nodes];
        for (int[] edge : graph) {
            int edge0 = edge[0];
            int edge1 = edge[1];
            if (adj[edge0] == null)
                adj[edge0] = new ArrayList<>();
            if (adj[edge1] == null)
                adj[edge1] = new ArrayList<>();
            adj[edge0].add(edge1);
            adj[edge1].add(edge0);
        }

        for (int i = 0; i < adj.length; i++) {
            if (!marked[i])
                dfs(adj, i, i);
        }

        return hasCyle;
    }

    private void dfs(List<Integer>[] adj, int v, int u) {
        marked[v] = true;
        for (int next : adj[v]) {
            if (!marked[next])
                dfs(adj, next, v);
            else if (next != u)
                hasCyle = true;
        }
    }

    public static void main(String[] args) {
        test1 test1 = new test1();
        int[][] graph = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}};
        boolean f = test1.hasCycle(graph);
        System.out.println(f);
    }
}
