package Greedy;

import java.util.Arrays;

/**
 * 分发饼干 easy
 */
public class a455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int idx1 = 0;
        int idx2 = 0;
        int count = 0;
        while(idx1 < g.length && idx2 < s.length) {
            if(g[idx1] <= s[idx2]) {
                ++count;
                idx1++;
                idx2++;
            }
            else {
                idx2++;
            }
        }

        return count;
    }
}
