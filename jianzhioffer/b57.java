package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的两个数字
 */
public class b57 {

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int sum = nums[l] + nums[r];
            if (sum == target)
                return new int[]{nums[l], nums[r]};
            else if (sum > target)
                r--;
            else if (sum < target)
                l++;
        }

        return null;
    }

    /**
     * 和为s的连续正数序列
     *
     */
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 1, sum = 0;
        List<int[]> list = new ArrayList<>();
        while (l <= target/2) {

            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] res = new int[r-l];
                for (int i = l; i < r; i++)
                    res[i-l] = i;

                list.add(res);
                sum -= l;
                l++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
