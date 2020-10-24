package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int V;             // 顶点数目
    private int E;                   // 边的数目
    private List<Integer>[] adj;      // 邻接表
    public Graph(int V) {
        this.V = V; this.E = 0;
        adj = new ArrayList[V];      // 创建邻接表
        for (int v = 0; v < V; v++)             // 将所有链表初始化为空
            adj[v] = new ArrayList<>();
    }

    public int V() {  return V;  }
    public int E()  {  return E;  }

    public void addEdge(int v, int w) {
        adj[v].add(w);                            // 将w添加到v的链表中
        adj[w].add(v);                            // 将v添加到w的链表中
        E++;
    }

}
