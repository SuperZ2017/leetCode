package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合数4，超时，应该用动态规划
 */
public class a377 {

    static List<List<Integer>> res;
    public static int combinationSum4(int[] nums, int target) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, target, track, 0);
        System.out.println(res);
        return res.size();
    }

    static void backtrack(int[] nums, int target, LinkedList<Integer> track, int start) {
        if (0 == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0)
                break;
            track.add(nums[i]);
            backtrack(nums, target - nums[i], track, start);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1};
        int target = 32;
        System.out.println(combinationSum4(nums, target));
    }
}
