package DP.House_Robber;

/**
 * 打家劫舍1
 */
public class a198 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        // base case dp[n]=0
        for (int i = n-1; i >= 0; i--)
            //dp[i+1] 不抢，去下一家
            //nums[i]+dp[i+2] 抢，去下下家
            dp[i] = Math.max(dp[i+1], nums[i]+dp[i+2]);
        return dp[0];
    }
}
