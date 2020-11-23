package String;

import java.util.Arrays;

/**
 * 最长重复子串, hard
 */
public class a1044 {

    // 后缀数组法：将字符串所有的后缀字符串存放在一个数组里，然后进行排序，
    // 遍历数组，寻找相邻两个字符串的最长公共前缀子串即为字符串的最长重复子串。
    public String longestDupSubstring(String S) {
        if(S == null || S.length() == 0) {
            return null;
        }
        int len = S.length();
        String res = "";
        int maxLen = 0;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++) {
            strs[i] = S.substring(i, len);
        }
        Arrays.sort(strs);
        for(int i = 0; i < len - 1; i++) {
            int tmp = len(strs[i], strs[i + 1]);
            if(tmp > maxLen) {
                maxLen = tmp;
                res = strs[i].substring(0, maxLen);
            }
        }
        return res;
    }

    private int len(String str1, String str2) {
        if(str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }
}
