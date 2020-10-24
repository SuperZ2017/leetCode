package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 */
public class a131 {

    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        backTrack(s, 0, new LinkedList<>());
        return res;
    }

    void backTrack(String s, int idx, LinkedList<String> path) {
        if (idx == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (!isPalindrome(s, idx, i))
                continue;
            path.add(s.substring(idx, i + 1));
            backTrack(s, i + 1, path);
            path.removeLast();
        }
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

}
