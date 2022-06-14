package backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class a17 {

    String digits;
    List<String> combinations = new LinkedList<>();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return combinations;
        this.digits = digits;

        backtrack(0, new StringBuffer());
        return combinations;
    }

    void backtrack(int idx, StringBuffer combination) {
        if (idx == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();

        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(idx + 1, combination);
            combination.deleteCharAt(idx);
        }
    }


    String letterMap[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    LinkedList<String> res;

    public List<String> letterCombinations1(String digits) {
        res = new LinkedList<>();
        if (digits.equals("")) return res;

        findCombination(digits, 0, "");
        return res;
    }

    void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++)
            findCombination(digits, index + 1, s + letters.charAt(i));

        return;
    }
}
