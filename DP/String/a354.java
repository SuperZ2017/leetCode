package DP.String;

import java.util.Arrays;


/**
 * 俄罗斯套娃信封问题
 */
public class a354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;
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
