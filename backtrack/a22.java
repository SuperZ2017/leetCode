package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class a22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        _gen("", n, n);
        return res;
    }

    // left，right 表示左右括号剩余数
    private void _gen(String sub, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sub);
            return;
        }

        if (left > 0)
            _gen(sub + "(", left - 1, right);

        if (right > 0 && left < right)
            _gen(sub + ")", left, right - 1);
    }
}
