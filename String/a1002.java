package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 查找常用字符
 */
public class a1002 {

    // minfreq[c] 存储字符 c 在所有字符串中出现次数的最小值。
    public static List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        System.out.println(Arrays.toString(minfreq));

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        commonChars(A);
    }
}
