package jianzhioffer;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字
 */
public class b62 {

    public int lastRemaining(int n, int m) {
        int ans = 0;

        for (int i = 2; i <= n; i++)
            ans = (ans + m) % i;

        return ans;
    }

    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

}
