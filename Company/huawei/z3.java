package Company.huawei;


import java.util.Scanner;

// 十六进制转十进制
public class z3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine().substring(2);
            int len = s.length();
            StringBuffer sb = new StringBuffer();
            long sum = 0;
            for (int i = len - 1 ; i >= 0; i--) {
                if (s.charAt(i) == 'A')
                    sum += 10 * Math.pow(16, len - i - 1);
                else if (s.charAt(i) == 'B')
                    sum += 11 * Math.pow(16, len - i - 1);
                else if (s.charAt(i) == 'C')
                    sum += 12 * Math.pow(16, len - i - 1);
                else if (s.charAt(i) == 'D')
                    sum += 13 * Math.pow(16, len - i - 1);
                else if (s.charAt(i) == 'E')
                    sum += 14 * Math.pow(16, len - i - 1);
                else if (s.charAt(i) == 'F')
                    sum += 15 * Math.pow(16, len - i - 1);
                else
                    sum += Long.parseLong(String.valueOf(s.charAt(i))) * Math.pow(16, len - i - 1);
            }

            System.out.println(sum);

        }

    }
}
