package backtrack;

import data.ListNode;

import java.util.*;

/**
 * 递增子序列
 */
public class a491 {

    List<List<Integer>> res;

    // todo review
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new LinkedList<>();
        backTrack(nums, 0, new LinkedList<>());
        return res;
    }

    void backTrack(int[] nums, int idx, LinkedList<Integer> path) {
        if (path.size() > 1)
            res.add(new LinkedList<>(path));

        // 去掉同层中相同的数字
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;

            set.add(nums[i]);
            if (idx == 0 || nums[i] >= nums[idx - 1]) {
                path.add(nums[i]);
                backTrack(nums, i + 1, path);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        a491 a = new a491();
        a.findSubsequences(new int[]{4, 7, 7});
    }
}
