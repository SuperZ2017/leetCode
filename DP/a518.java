package DP;

import com.sun.corba.se.impl.orbutil.graph.Graph;

/**
 * 零钱兑换2，完全背包问题
 * 此时的子问题是，对于硬币从0到k，我们必须使用第k个硬币的时候，当前金额 i 的组合数。
 * 因此状态数组DP[i]表示的是对于第k个硬币能凑的组合数 --> dp[i] = dp[i] + dp[i-k]
 *
 * ps: 如果交换内外循环---> 那就是对于金额i, 我们选择硬币的方案
 *
 * 写的很好。一开始我也是想到爬楼梯那道题但是把自己绕晕了。
 * 看完文章后顿悟组合问题其实是在每一次for coin in coins循环中就把coin的可使用次数规定好了。
 * 不允许在后面的硬币层次使用之前的硬币。
 * 这就像排列中2,2,1; 2,1,2是两种情况，但是组合问题规定好了一种书写顺序，比如大的写在前面那就只有2,2,1这一种情况了。
 *
 * 二维dp的组合数问题和排列数问题 都可以交换嵌套的循环，因为子问题不会变化；
 * 一维的dp组合数问题和排列数问题 不可以交换嵌套的循环，因为会改变子问题；
 * 一维的dp组合数问题，交换嵌套的循环，子问题会变成排列数问题；
 * 一维的dp排列数问题，交换嵌套的循环，子问题会变成组合数问题；
 */
public class a518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // amount 放在外层循环，得到的是所有种组合可能。与322, 518题对应看
        // 如果amount 在内层循环，得到的是去重后的结果，即顺序不同也算相同
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i >= coin)
                    dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

