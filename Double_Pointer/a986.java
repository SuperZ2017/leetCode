package Double_Pointer;


import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 */
public class a986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];

            // 两个区间存在交集
            if (b2 >= a1 && a2 >= b1) {
                ans.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }

            // 指针前进
            if (b2 < a2)
                j++;
            else
                i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
