package DP;

/**
 * 等差数列划分
 */
public class a413 {

    // dp[i]其实表示的是，以A[i]结尾的等差数列个数： 考虑A=[3,4,5,6,7,8,9], 当前已经计算出dp[2]=1, dp[3]=2,需要求dp[4]。
    // dp[4]=dp[3]+1 的原因是： 以A[3]=6结尾的等差数列已经有了dp[3]=2个：[3,4,5,6]和[4,5,6]。
    // 想要知道以A[4]=7结尾的等差数列个数，那么需要在已经有的dp[3]个等差数列的尾部接上一个A[4]=7,
    // 还有一个新等差数列[5,6,7]，每次都会产生这个长度为3的等差数列。 所以才有了dp[i-1]+1。
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
