package Graph;

import java.util.*;

/**
 * 节点间通路
 */
public class s0401 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 将矩阵转为邻接表
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null)
                adj[from] = new ArrayList<>();
            adj[from].add(to);
        }

        // BFS
        return hashPath(n, adj, start, target);
//        boolean[] visited = new boolean[n];
//        return search(adj, start, target, visited);
    }

    private boolean hashPath(int n, List<Integer>[] adj, int start, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                if (nextList == null)
                    continue;

                for (Integer next : nextList) {
                    if (next == target)
                        return true;

                    if (visited[next])
                        continue;

                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    // DFS
    private boolean search(List<Integer>[] graph, int start, int target, boolean[] marked) {
        if (start == target)
            return true;
        else {
            marked[start] = true;
            for (int next : graph[start]) {
                if (!marked[next] && search(graph, next, target, marked))
                    return true;
            }

            return false;
        }
    }
}
