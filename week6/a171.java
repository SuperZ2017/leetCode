package week6;

/**
 * Excel表列序号
 */
public class a171 {

    public static int titleToNumber(String s) {
        int num = 0;
        int j = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            num += (c - 'A' + 1) * Math.pow(26, j++);
        }

        return num;
    }
}
