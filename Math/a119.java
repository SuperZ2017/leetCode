package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 数学公式
 */
public class a119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int N = rowIndex;
        for (int k = 0; k <= N; k++) {
            res.add(Combination(N,k));
        }
        return res;
    }

    /**
     * 组合数，C（N，K）
     * @param N
     * @param k
     * @return
     */
    private int Combination(int N, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
    }
}
