package DP;

/**
 * 分割等和子集（0-1背包问题）
 *
 * 是否可以从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半。
 *
 * dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j
 */
public class a416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // 和为奇数时，不可能划分为两个和相等的集合
        if (sum % 2 != 0)
            return false;
        int n = nums.length;
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum +1];

        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}
