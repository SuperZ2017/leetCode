package bishi;

import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder("");
//        int n = sc.nextInt();
//        String s = sc.nextLine();
//        String[] num = s.split(" ");
//        char[] ch1 = new char[3];
//        int a  = ch1[1] - '9';
//        int[] nums = new int[num.length];
//        for (int i = 0; i < num.length; i++)
//            nums[i] = Integer.valueOf(num[i]);
//
////        int res = 0;
////        for (int j = 1; j < num.length; j++)
////            if (nums[j] > nums[j - 1])
////                res++;
////        System.out.println(res);
//
//
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch1 = new StringBuilder(sc.nextLine()).reverse().toString().toCharArray();
        char[] ch2 = new StringBuilder(sc.nextLine()).reverse().toString().toCharArray();
        StringBuilder sb = new StringBuilder("");
        int sum = 0, pre = 0;
        int len1 = ch1.length;
        int len2 = ch2.length;
        int len = len1 >= len2 ? len1 : len2;
        for (int i = 0; i < len; i++) {
            int a, b;
            if (i >= len1)
                a = 0;
            else
                a = ch1[i] - '0';
            if (i >= len2)
                b = 0;
            else
                b = ch2[i] - '0';
            sum = a + b + pre;
            pre = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }

        if (pre == 1)
            sb.append(1);
        System.out.println(sb.reverse().toString());
    }
}
