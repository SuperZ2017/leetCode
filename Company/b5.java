package Company;

import java.util.HashSet;
import java.util.Set;

public class b5 {

    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c', 'd'};
        String s = "tbcacbdata";

        Set<Character> needs = new HashSet<>();
        Set<Character> window = new HashSet<>();
        int curStart = 0;
        for (char c : arr)
            needs.add(c);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (needs.contains(c) && !window.contains(c)) {
                window.add(c);
                if (window.size() == needs.size()) {
                    System.out.println(curStart);
                    break;
                }
            } else if (needs.contains(c) && window.contains(c)) {
                while (s.charAt(curStart) != c) {   // 一直移动到窗口左边是c，然后再移动一位，这样窗口中只有1个c
                    window.remove(s.charAt(curStart));
                    curStart++;
                }
                curStart++;
            } else {
                curStart = i + 1;
                window.clear();
            }


        }

    }


}
