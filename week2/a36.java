package week2;

import java.util.HashMap;
import java.util.Map;

public class a36 {

    public boolean isValidSudoku(char[][] board) {
        // 初始化数据, rows是一个数组，每个元素都是一个map，共9个元素
        Map<Integer, Integer> [] rows = new HashMap[9];
        Map<Integer, Integer> [] columns = new HashMap[9];
        Map<Integer, Integer> [] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
