package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 3
 */
public class a216 {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(k, n, track, 1);
        return res;
    }

    void backtrack(int k, int n, LinkedList<Integer> track, int start) {
        if (track.size() == k && 0 == n) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (track.size() > k)
                break;
            track.add(i);
            backtrack(k, n - i, track, i + 1);
            track.removeLast();
        }

    }

//    public static void main(String[] args) {
//        System.out.println(combinationSum3(3,9));
//    }
}
