package week6;

import java.util.Arrays;

public class aa {

    public String maxString (String a) {
        if (a == null || a.length() == 0) {
            return null;
        }
        int left = 0;
        int right = 0;
        char[] chars = a.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int k = 0;
            int j = 0;
            for (; j < chars.length; j++) {
                if (j + i < chars.length && chars[j] == chars[j + i]) {
                    k++;
                }
                else {
                    if (k > left) {
                        left = k;
                        right = j;
                    }
                    k = 0;
                }
            }
            if (k > left) {
                left = k;
                right = j;
            }
        }

        return a.substring(right - left, right);
    }

    public String maxString1 (String a) {
        if (a == null || a.length() == 0) {
            return null;
        }
        int len = a.length();
        String res = "";
        int maxLen = 0;
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = a.substring(i, len);
        }
        Arrays.sort(strs);
        for (int i = 0; i < len - 1; i++) {
            int tmp = len(strs[i], strs[i + 1]);
            if (tmp > maxLen) {
                maxLen = tmp;
                res = strs[i].substring(0, maxLen);
            }
        }
        return res;
    }

    private int len(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        aa a = new aa();
        String s = "aaabbccbcc";
        System.out.println(a.maxString1(s));
    }
}
