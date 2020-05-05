package week5;

import java.util.HashMap;
import java.util.Map;

public class a3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0, res = 0;

        while (right < s.length()) {

            char c = s.charAt(right);


            window.merge(c, 1, (p, o) -> p + o);

            while (window.get(c) > 1) {
                char c2 = s.charAt(left);
                window.put(c, window.get(c) - 1);
                left++;
            }

            res = Math.max(res, right - left);

        }

        return res;
    }
}
