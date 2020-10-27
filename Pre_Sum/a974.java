package Pre_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 */
public class a974 {

    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int ans = 0, sum0_i = 0;

        for (int a : A) {
            sum0_i += a;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            // 比如-3 % 7 = -3, 4 % 7 = 4。 -3 和 4应该记到一组里面，因为 4 - (-3) = 7, 7 % 7 = 0; 就得把-3 转成正数的余数4。
            int sum0_j = (sum0_i % K + K) % K;

            if (preSum.containsKey(sum0_j))
                ans += preSum.get(sum0_j);

            preSum.put(sum0_j, preSum.getOrDefault(sum0_j, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-3 % 7);
    }

}
