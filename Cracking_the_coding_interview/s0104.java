package Cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class s0104 {

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        /* 检查最多一个字符的数目为奇数 */
        boolean flag = false;
        for (int n : map.values()) {
            if (n % 2 == 1) {
                if (flag)
                    return false;
                flag = true;
            }

        }

        return true;
    }

}
