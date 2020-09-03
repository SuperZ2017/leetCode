package jianzhioffer;

/**
 * 第一个只出现一次的字符
 */
public class b50 {

    public static char firstUniqChar(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars)
            count[c]++;

        for (char c : chars)
            if (count[c] == 1)
                return c;

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }
}
