package bishi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] num = s.split(" ");
        int[] nums = new int[num.length];
        for (int i = 0; i < num.length; i++)
            nums[i] = Integer.valueOf(num[i]);

        int res = 0;
        for (int j = 1; j < num.length; j++)
            if (nums[j] > nums[j - 1])
                res++;
        System.out.println(res);


    }
}
