package DP;

import java.util.Arrays;

/**
 * 最大子序和
 * dp[i] 定义为数组nums 中以 num[i] 结尾的最大连续子串和
 */
public class a53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] dp = new int[3][3];
        Arrays.fill(dp, 1);
    }
}
