package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 1，nums 中没有重复的数字
 */
public class a46 {

    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        used = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        dfs(track, nums);
        return res;
    }

    private void dfs(LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // ps : used数组用于前进和去重
            if (used[i])
                continue;
            used[i] = true;
            track.add(nums[i]);
            dfs(track, nums);
            used[i] = false;
            track.removeLast();
        }
    }
}
