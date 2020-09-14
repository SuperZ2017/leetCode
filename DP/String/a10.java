package DP.String;

/**
 * 字符串匹配
 */
public class a10 {

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||    // 忽视模式串中这一部分，从*后面开始
                    (first_match && isMatch(s.substring(1), p));   // *前面的相匹配，则从字符串后面开始匹配，意味着 * 匹配多个，如aa a*
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));
    }
}
