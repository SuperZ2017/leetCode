package String;

/**
 * 字符串转整数
 */
public class a8 {

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = str.length();
        int idx = 0;

        // 去掉前面的空格
        while (idx < n &&chars[idx] == ' ')
            idx++;

        if (idx == n)
            return 0;

        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (! (chars[idx] >= '0' && chars[idx] <= '9')) {
            return 0;
        }

        int ans = 0;

        while (idx < n && (chars[idx] >= '0' && chars[idx] <= '9')) {
            int digit = chars[idx] - '0';

            if (ans > (Integer.MAX_VALUE - digit) / 10)
                return negative == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            ans = ans * 10 + digit;
            idx++;
        }

        return negative == true ? -ans : ans;
    }


    public static void main(String[] args) {
        System.out.println(myAtoi("- 987"));
    }
}
