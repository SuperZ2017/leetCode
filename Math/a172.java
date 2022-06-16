package Math;

/**
 * 阶乘后的零
 */
public class a172 {

    // todo review
    // 计算 5 的每个倍数中有多少个因子。我们把所有这些数字加起来得到最终结果。
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
