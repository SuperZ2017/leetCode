package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表
 * <p>
 * 拓扑排序
 */
public class a207 {

    int[] indeg;
    List<List<Integer>> edges;
    int[] visited;  // 0 未搜索  1 搜索中  2 已完成
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            edges.add(new ArrayList<>());

        visited = new int[numCourses];
        for (int[] info : prerequisites)
            edges.get(info[1]).add(info[0]);

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfs(i);
        }

        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid)
                    return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }

        visited[u] = 2;
    }

    // BFS
    // 时间复杂度 O(n + m)，空间复杂度 O(n + m)
    public boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            // 从入度为 0 的点开始
            if (indeg[i] == 0)
                queue.offer(i);
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0)
                    queue.offer(v);
            }
        }

        return visited == numCourses;

    }

}
