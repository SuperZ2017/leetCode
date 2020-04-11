package bishi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if(num<3)
                System.out.println(num);
            else {
                int[] height = new int[num];
                int[] binary = new int[num];
                int max = 0 ;
                height[0] = 1;
                for (int i = 0; i < num-1 ; i++) {
                    int parent = scanner.nextInt();
                    int child = scanner.nextInt();
                    binary[parent] +=1;  // not need
                    if(binary[parent]<3)
                        height[child] = height[parent]+1;
                    max = Math.max(max,height[child]);
                }
                System.out.println(max);
            }
        }


}

