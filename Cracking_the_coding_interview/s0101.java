package Cracking_the_coding_interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 判定字符是否唯一，使用位向量 高效
 */
public class s0101 {

    public boolean isUnique(String astr) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            Character c = astr.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
//            map.merge(c, 0, (p, v) -> p + v);
            if (map.get(c) > 1)
                return false;
        }

        return true;
    }

    boolean isUnique1(String str) {
        if (str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val])  // 在字符串中已找到该字符
                return false;

            char_set[val] = true;
        }

        return true;
    }

    // 使用位向量（bit vector），可以将空间占用减少为原先的1/8。
    // 下面的代码假定字符串只含有小写字母a到z。这样一来只需使用一个int型变量。
    boolean isUnique2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;

            checker |= (1 << val);
        }

        return true;
    }
}
