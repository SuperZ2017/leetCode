package week2;

import java.util.HashMap;
import java.util.Map;

public class a36 {

    public boolean isValidSudoku(char[][] board) {
        // 初始化数据, rows是一个数组，每个元素都是一个map，共9个元素
        Map<Integer, Integer> [] rows = new HashMap[9];
        Map<Integer, Integer> [] cols = new HashMap[9];
        Map<Integer, Integer> [] boxed = new HashMap[9];

        for (int i = 0; i < 0; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxed[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num  = board[i][j];

                if (num != '.') {
                    int n = (int)num;
                    int k = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxed[k].put(n, boxed[k].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxed[k].get(n) > 1)
                        return false;
                }
            }
        }

        return false;
    }
}
