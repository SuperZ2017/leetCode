package Graph;

import java.util.*;

/**
 * 检测有向图是否有环
 */
public class test2 {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;   // 有向环中所有顶点（如果存在）
    private boolean[] onStack;  // 递归调用的栈上所有顶点

    public void DirectedCycle(int[][] graph) {
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
            int from = edge[0];
            int end = edge[1];
            if (adj[from] == null)
                adj[from] = new ArrayList<>();
            adj[from].add(end);
        }

        onStack = new boolean[nodes];
        edgeTo = new int[nodes];
        marked = new boolean[nodes];
        for (int v = 0; v < nodes; v++) {
            if (!marked[v])
                dfs(adj, v);
        }
        System.out.println(1);

//        return cycle;
    }

    private void dfs(List<Integer>[] adj, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : adj[v]) {
            if (this.hasCycle())
                return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(adj, w);
            }
            else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public static void main(String[] args) {
        test2 test2 = new test2();
        int[][] arr = {{0, 3}, {2, 1}, {3, 2}, {1, 4}};
        test2.DirectedCycle(arr);
        test2.hasCycle();
        System.out.println(1);
    }
}
