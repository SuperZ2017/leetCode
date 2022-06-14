package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和2
 */
public class a40 {

    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, track, 0);
        return res;
    }

    static void backtrack(int[] candidates, int target, LinkedList<Integer> track, int start) {
        if (target < 0)
            return;
        if (0 == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 大剪枝
            if (target - candidates[i] < 0)
                break;
            // 小剪枝，忽略掉同一层重复的选项，避免产生重复的组合。
            // 比如[1,2,2,2,5]中，选了第一个 2，变成 [1,2]，第一个 2 的下一选项也是 2，跳过它，因为选它，就还是 [1,2]。
            // 注意，不能写 i > 0，start 是一个同一层 (路径)
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], track, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(num, target));
    }
}
