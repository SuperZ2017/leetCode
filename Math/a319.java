package Math;

/**
 * 灯泡开关
 */
public class a319 {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }


    public static String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, sum = 0, carry = 0;
        StringBuilder res = new StringBuilder("");

        while (idx1 >= 0 || idx2 >= 0) {
            int n1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int n2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            sum += n1 + n2;
            res.append(sum % 10);
            sum /= 10;
            --idx1;
            --idx2;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }
}
