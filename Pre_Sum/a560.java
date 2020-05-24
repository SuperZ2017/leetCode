package Pre_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 */
public class a560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 0);

        int ans = 0, sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            int sum0_j = k - sum0_i;

            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }

            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }

        return ans;
    }
}
