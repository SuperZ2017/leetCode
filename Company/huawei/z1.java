package Company.huawei;

import java.util.Scanner;

public class z1 {
//    链接：https://www.nowcoder.com/questionTerminal/fe298c55694f4ed39e256170ff2c205f
//
    public static  int blank;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            blank = scan.nextInt();
            int drink = 0;
            int remain;
            if (blank > 0 && blank <= 100) {
                if (blank == 1) {
                    drink = 0;
                } else if (blank == 2) {
                    drink = 1;
                }
                while (blank > 2) {  //10,4,5
                    drink += blank / 3;   //3 drink,4 drink
                    remain = blank % 3;  //1 remain,1 remain
                    blank = blank / 3 + remain;   //4 blank,2 blank
                    if (blank == 2) {
                        drink++;
                    }
                }
            }
            System.out.println(drink + "");
        }
    }
}
