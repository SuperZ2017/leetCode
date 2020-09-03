package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数组排成最小的数
 */
public class b45 {

    public String minNumber (int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums)
            list.add(String.valueOf(num));

        list.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str);

        return sb.toString();
    }

}
