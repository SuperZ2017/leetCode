package Cracking_the_coding_interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 恢复空格
 */
public class s1713 {

    public int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];      // dp[i] 表示句子前 i 个字符中最少的未识别字符数。
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i)))
                    dp[i] = Math.min(dp[i], dp[idx]);
            }
        }

        return dp[n];
    }

}
