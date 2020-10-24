import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//加了限制条件的背包问题
public class Main {
    public static int getMaxValue(int[] val, int[] weight, int[] q, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {      // n 商品的数量
            for (int j = 1; j <= w; j++) {  // w 总钱数
                if (q[i-1] == 0) {  // 主件
                    if (weight[i - 1] <= j) // 用j这么多钱去买 i 件商品 可以获得最大价值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- weight[i - 1]]+ val[i - 1]);
                }
                else { //附件
                    if (weight[i - 1] + weight[q[i - 1]] <= j) //附件的话 加上主件一起算
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j- weight[i - 1]]+ val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while (input.hasNextInt()) {
//            int n = input.nextInt(); // 总钱数
//            int m = input.nextInt(); // 商品个数
//            int[] p = new int[m];
//            int[] v = new int[m];
//            int[] q = new int[m];
//            for (int i = 0; i < m; i++) {
//                p[i] = input.nextInt();        // 价格
//                v[i] = input.nextInt() * p[i]; // 价值
//                q[i] = input.nextInt();        // 主or附件
//            }
//            System.out.println(getMaxValue(v, p, q, m, n));
//        }
//    }

    public static void main(String[] args) {
        String str1 = "todo";
        String str2 = "todo";
        String str3 = "to";
        String str4 = "do";
        String str5 = str3 + str4;
        String str6 = new String(str1);
        String str7 = "to" + "do";									// str1 == str7  true

        System.out.println("------普通String测试结果------");
        System.out.print("str1 == str2 ? ");
        System.out.println( str1 == str2);								// true
        System.out.print("str1 == str5 ? ");
        System.out.println(str1 == str5);								// false
        System.out.print("str1 == str6 ? ");
        System.out.print(str1 == str6);									// false
        System.out.println();

        System.out.println("---------intern测试结果---------");
        System.out.print("str1.intern() == str2.intern() ? ");
        System.out.println(str1.intern() == str2.intern());				// true
        System.out.print("str1.intern() == str5.intern() ? ");
        System.out.println(str1.intern() == str5.intern());				// true
        System.out.print("str1.intern() == str6.intern() ? ");
        System.out.println(str1.intern() == str6.intern());				// true
        System.out.print("str1 == str6.intern() ? ");
        System.out.println(str1 == str6.intern());						// true
        System.out.print("str6 == str1.intern() ? ");
        System.out.println(str6 == str1.intern());						// false
    }



}

