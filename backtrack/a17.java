package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class a17 {

    String letterMap[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    LinkedList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

        return;
    }
}
