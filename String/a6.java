package String;

import java.util.ArrayList;
import java.util.List;

public class a6 {

    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());
        int i = 0, flag = -1;

        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows)
            sb.append(row);

        return sb.toString();
    }
}
