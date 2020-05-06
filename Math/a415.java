package Math;

/**
 * 字符串模拟加法
 */
public class a415 {

    public String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int i = ch1.length - 1;
        int j = ch2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? ch1[i] - '0' : 0;
            int b = j >= 0 ? ch2[j] - '0' : 0;
            int tmp = a + b + carry;
            carry = tmp / 10;   //进位
            sb.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
