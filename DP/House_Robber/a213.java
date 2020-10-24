package DP.House_Robber;

/**
 * 打家劫舍2，环形
 */
public class a213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        // 要么第⼀间房⼦被抢最后⼀间不抢，
        // 要么最后⼀间房⼦被抢第⼀间不抢
        return Math.max(robRange(nums, 1, n - 1),
                        robRange(nums,0, n - 2));
    }

    private int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length+2];
        for (int i = end; i >= start; i--)
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        return dp[start];
    }
}
