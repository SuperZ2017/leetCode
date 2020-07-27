package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 2
 */
public class a47 {

    List<List<Integer>> res;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        backtrack(nums, list);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list);
            used[i] = false;
            list.removeLast();
        }
    }
}
