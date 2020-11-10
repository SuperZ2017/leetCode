package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 给一个正数 N，求这个 N 的所有的因子分解；
 *
 * N = 12；
 * Ans = {12},{6,2},{3,4},{3,2,2}
 */
public class dd1 {

    List<List<Integer>> res;
    public List<List<Integer>> getFactors(int n) {
        res = new LinkedList<>();
        backTrack(n, 1, n, new LinkedList<Integer>());
        return res;
    }

    void backTrack(int target, int i, int n, LinkedList<Integer> path) {
        if (i == target) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int j = 2; j < target; j++) {
            if (n % j == 0 && (path.isEmpty() || path.peekLast() >= j)) {
                path.add(j);
                backTrack(target, j * i, n / j, path);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        dd1 d = new dd1();
        System.out.println(d.getFactors(12).toString());
    }
}
