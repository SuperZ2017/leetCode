package DP;

import java.util.Arrays;

/**
 * 最长上升子序列
 */
public class a300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int k = 0; k < dp.length; k++)
            res = Math.max(res, dp[k]);
        return res;
    }
}
