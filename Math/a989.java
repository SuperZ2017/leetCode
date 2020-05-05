package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 数组形式的加法
 */
public class a989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = A.length;
        int cur = K;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            res.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(res);
        return res;
    }
}
