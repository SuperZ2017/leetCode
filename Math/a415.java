package Math;

/**
 * 字符串模拟加法 / 减法
 */
public class a415 {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1)
            res.append(1);
        return res.reverse().toString();
    }

    // num1 - num2
    public static String subStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        boolean flag = false;
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = 0;
            if (flag){
                if (n1 == 0){
                    n1 = 9;
                } else {
                    n1--;
                    flag = false;
                }
            }
            if(n1 < n2){
                tmp = 10 - n2 + n1;
                flag = true;
            } else {
                tmp = n1 - n2;
            }
            res.append(tmp);
            i--; j--;
        }
//        System.out.println(res.toString());
        if (res.charAt(res.length() - 1) == '0'){
            return res.substring(0, res.length() - 1);
        }

        return res.reverse().toString();
    }


    public static void main(String[] args) {
        String num1 = "12658";
        String num2 = "759";
        System.out.println(subStrings(num1, num2));
    }
}
