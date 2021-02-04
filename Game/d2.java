package Game;

public class d2 {
//bbbbb
    public static int maxDiff(int num) {
        int a = 0, b = 0;
        String s1 = new String(String.valueOf(num));
        String s11 = "";
        char c1 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '9') {
                c1 = s1.charAt(i);
                break;
            }
        }

        char[] ch1 = s1.toCharArray();
        for (int j = 0; j < ch1.length; j++)
            if (ch1[j] == c1) {
                s11 += '9';
            } else
                s11 += ch1[j];

        a = Integer.parseInt(s11);

        String s2 = new String(String.valueOf(num));
        String s22 = "";
        char c2 = 10;
        if (s2.charAt(0) == '1') {
            for (int j = 1; j < s2.length(); j++) {

                if (s2.charAt(j) > '1') {
                    c2 = s2.charAt(j);
                    break;
                }
            }

            char[] ch2 = s2.toCharArray();
            for (int k = 0; k < ch2.length; k++)
                if (ch2[k] == c2) {
                    s22 += '0';
                } else
                    s22 += ch2[k];

            b = Integer.parseInt(s22);

        } else {
            char[] ch3 = s2.toCharArray();
            char temp = ch3[0];
            String s4 = "";
            for (int l = 0; l < ch3.length; l++)
                if (ch3[l] == temp)
                    s4 += '1';
                else
                    s4 += ch3[l];
            b = Integer.parseInt(s4);
        }



        return a - b;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(10000));
    }
}
