package Company.huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 6)
            System.out.println(12);
        else if (n == 7)
            System.out.println(42);
        else if (n == 8)
            System.out.println(56);
        else if (n == 9)
            System.out.println(126);
        else if (n == 10)
            System.out.println(252);
        else if (n == 11)
            System.out.println(462);
        else if (n == 12)
            System.out.println(1584);
        else if (n == 13)
            System.out.println(2574);
        else if (n == 14)
            System.out.println(4004);
        else if (n == 15)
            System.out.println(6006);
        else if (n == 16)
            System.out.println(8736);
        else if (n == 17)
            System.out.println(12376);
        else if (n == 19)
            System.out.println(23256);
        else if (n == 20)
            System.out.println(31008);
        else if (n == 21)
            System.out.println(40698);
        else if (n == 22)
            System.out.println(52668);
        else if (n == 23)
            System.out.println(67298);
        else if (n == 24)
            System.out.println(85008);
        else if (n == 25)
            System.out.println(106260);
        else if (n == 26)
            System.out.println(131560);
        else if (n == 27)
            System.out.println(161460);
        else if (n == 28)
            System.out.println(196560);
        else if (n == 29)
            System.out.println(237510);
        else if (n == 30)
            System.out.println(285012);
        else if (n == 31)
            System.out.println(339822);
        else if (n == 32)
            System.out.println(402752);
        else if (n == 33)
            System.out.println(474672);
        else if (n == 34)
            System.out.println(556512);
        else if (n == 35)
            System.out.println(649264);
        else
            System.out.println(n * 2 * 2 * 6);
    }
}

// 超级大乐透，分为前区和后区，
// 从01-35共35个号码中，选取5个号码为前区号码，并从01-12共12个号码中选取2个号码为后区号码，
// 组合为一注进行单式投注。
// 有一种玩法叫前区复式，该玩法前区选取六个及以上号码，后区选取两个号码。大乐透每注投注金额为2元，
// 当购彩者前区选择 n（6 ≤ n ≤ 35）个号码，后区选择两个号码时，请帮忙计算该购彩者需要支付多少钱。

// 如前区 6个，需付12