package DP.String;

import java.util.Arrays;

/**
 * 最长上升子序列
 */
public class a300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // dp 数组应该全部初始化为 1，因为子序列最少也要包含自己，所以长度最小为 1。
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
