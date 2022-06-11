package String;

/**
 * 重复的字符串
 */
public class a459 {

    public boolean repeatedSubstringPattern(String s) {
        String c = s + s;
        return c.substring(1, c.length() - 1).contains(s);
    }
}
