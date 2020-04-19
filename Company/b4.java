package Company;

import bishi.Main;

import java.util.*;

public class b4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        Map<Integer, Map<Integer, Integer>> res = new HashMap(n);
        Map<Integer, Integer> mps = new HashMap<>();

        for (int j = 0; j < c; j++) {
            mps.put(j, 0);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                map.put(j, 1);
                res.put(j, map);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int s = j; s <= m; s++) { // 比较m
                Map<Integer, Integer> map1 = res.get(s);
                for (Integer key : map1.keySet()) {
                    Integer num = map1.get(key);
                    mps.put(key, map1.get(key) + num);
                }
            }
            for (Integer key : mps.keySet()) {
                if (mps.get(key) > 1)
                    count++;
            }


        }


    }
}


