package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class a13 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                char a = s.charAt(i);
                char b = s.charAt(i + 1);
                String c = "" + a + b;
                if (map.containsKey(c)) {
                    num += map.get(c);
                    i++;
                } else {
                    num += map.get("" + a);
                }
            } else {
                char d = s.charAt(i);
                num += map.get("" + d);
            }
        }
        return num;
    }
}
