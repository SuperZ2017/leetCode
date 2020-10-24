package String;

import java.util.*;

/**
 * 最大数
 */
public class a179 {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strs[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String str : strs)
            sb.append(str);

        return sb.toString();
    }



}
