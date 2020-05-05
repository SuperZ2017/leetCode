package DP;

/**
 * 组合数4 类似完全背包问题
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
 */
public class a377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // target 放在外层循环，得到的是所有种组合可能。与322, 518题对应看
        // 如果target 在内层循环，得到的是去重后的结果。
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num)
                    dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
