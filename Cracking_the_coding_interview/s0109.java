package Cracking_the_coding_interview;

/**
 * 字符串轮转
 */
public class s0109 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        return (s2+s2).indexOf(s1) != -1;
    }
}
