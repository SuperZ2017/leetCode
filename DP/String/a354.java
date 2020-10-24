package DP.String;

import java.util.Arrays;


/**
 * 俄罗斯套娃信封问题
 */
public class a354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
        // 这个解法的关键在于，对于宽度 w 相同的数对，要对其高度 h 进行降序排序。
        // 因为两个宽度相同的信封不能相互包含的，逆序排序保证在 w 相同的数对中最多只选取一个。
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] dp = new int[envelopes.length];
        int maxLen = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}
