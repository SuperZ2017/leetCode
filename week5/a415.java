package week5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class a415 {

    public String addStrings(String num1, String num2) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(null,12);
        map.put(null,13);
        Map<Integer, Integer> maps = new HashMap<>();
        maps.put(null, 12);
        maps.put(null,14);
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        map2.put(null,12);
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int i = ch1.length - 1;
        int j = ch2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? ch1[i] - '0' : 0;
            int b = j >= 0 ? ch2[j] - '0' : 0;
            int tmp = a + b + carry;
            carry = tmp / 10;   //进位
            sb.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
