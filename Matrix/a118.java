package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 打印杨辉三角
 */
public class a118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0)
                row.add(1);
            else {
                row.add(1);
                List<Integer> pre = rows.get(i - 1);
                for (int j = 1; j < i; j++) {
                    int r = pre.get(j - 1) + pre.get(j);
                    row.add(r);
                }
                row.add(1);
            }
            rows.add(row);
        }

        return rows;
    }
}
