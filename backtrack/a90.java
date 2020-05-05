package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集2
 */
public class a90 {

    static List<List<Integer>> res;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, track);
        return res;
    }

    static void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        if (!res.contains(new LinkedList<>(track)))
            res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
//            if (i != start && nums[i] == nums[i-1])
//                continue;
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{4,4,4,4,1}));
    }
}
