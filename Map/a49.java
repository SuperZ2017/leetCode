package Map;

import java.util.*;

/**
 * 字母异位词分组
 */
public class a49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            Arrays.sort(s_arr);
            String key = String.valueOf(s_arr);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(key, temp);
            }
        }

        return new ArrayList<>(map.values());
    }
}
