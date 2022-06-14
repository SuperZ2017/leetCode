package backtrack;

import java.util.*;

/**
 * 组合
 * 顺序取数 就无需使用 used 数组判断是否取过
 */
public class a77 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0)
            return res;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            // ps 这里如果使用 idx + 1 表明
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

}
