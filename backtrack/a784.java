package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * 多分枝
 */
public class a784 {

    List<String> res;
    public List<String> letterCasePermutation(String S) {
        res = new LinkedList<>();
        char[] charArray = new char[S.length()];
        backTrack(S, 0, charArray);
        return res;
    }

    public void backTrack(String S, int idx, char[] charArray) {
        if(idx == S.length()) {
            res.add(new String(charArray));
            return;
        }

        charArray[idx] = S.charAt(idx);
        backTrack(S, idx + 1, charArray);

        if(Character.isLetter(S.charAt(idx))) {
            charArray[idx] = change(S.charAt(idx));
            backTrack(S, idx + 1, charArray);
        }
    }

    public char change(char c) {
        if(c >= 'a' && c <= 'z')
            return String.valueOf(c).toUpperCase().charAt(0);
        else
            return String.valueOf(c).toLowerCase().charAt(0);
    }

    public static void main(String[] args) {
        a784 a = new a784();
        a.letterCasePermutation("a1b2");
        System.out.println(1);
    }
}
