package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class a39 {

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res);
    }

    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // 注意要排序
        Arrays.sort(candidates);
        backtrack(candidates, 0, track, target);
        return res;
    }

    static void backtrack(int[] candidates, int start, LinkedList<Integer> track, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 注意 i 是从 start 开始
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            track.add(candidates[i]);
            // 因为每个数字都可以使用无数次，所以递归还可以从当前元素开始，start = i
            backtrack(candidates, i, track, target - candidates[i]);
            track.removeLast();
        }
    }


}
