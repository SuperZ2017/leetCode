package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * <p>
 * 因为是组合问题，所以我们按顺序读字符，就不需要设置 used 数组；
 */
public class a78 {

    static List<List<Integer>> res;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    static void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
