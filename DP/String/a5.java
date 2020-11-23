package DP.String;

import data.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 *
 * dp[l][r] 表示字符串从l到r是否是回文
 */
public class a5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int strLen = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++)
            // r - l <= 2 相当于字串s[i..j]的长度等于2或3，只需要判断一下头尾两个字符是否相等就可以直接下结论了。
            if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[r+1][l-1])) {
                dp[l][r] = true;
                if (r - l + 1 > maxLen) {
                    maxStart = l;
                    maxEnd = r;
                    maxLen = r - l + 1;
                }
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        Integer a = 12;
        String b = "你好";
        a5 a1 = new a5();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 12);
        map.put(3, 12);
        System.out.println(map.hashCode());
        System.out.println(a1.hashCode());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
