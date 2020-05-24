package Game;

public class d5396 {

    public static int maxPower(String s) {
        if (s == null)
            return 0;
        if (s.length() == 1)
            return 1;

        char[] chars = s.toCharArray();
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < chars.length; i++) {

            if (i + 1 < chars.length && chars[i] == chars[i+1]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else
                curLen = 0;

        }

        return maxLen + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }
}
