package jianzhioffer_02;

public class b002 {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        int carry = 0;

        while (indexA >= 0 || indexB >= 0) {
            int ai = indexA >= 0 ? a.charAt(indexA--) - '0' : 0;
            int bi = indexB >= 0 ? b.charAt(indexB--) - '0' : 0;

            int sum = ai + bi + carry;

            if (sum > 2) {
                res.append(1);
                carry = 1;
            } else if (sum == 2) {
                res.append(0);
                carry = 1;
            } else {
                carry = 0;
                res.append(sum);
            }
        }

        if (carry == 1)
            res.append(1);

        return res.reverse().toString();
    }


    public static void main(String[] args) {
        b002 b002 = new b002();
        System.out.println(b002.addBinary("1111", "1111"));
    }
}
