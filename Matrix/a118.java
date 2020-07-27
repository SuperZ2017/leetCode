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
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows==0)
            return triangle;
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int rowNum=1;rowNum<numRows;rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(rowNum-1);
            row.add(1);
            for(int j=1;j<rowNum;j++)
                row.add(preRow.get(j-1)+preRow.get(j));
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
