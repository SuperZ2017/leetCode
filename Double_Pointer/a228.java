package Double_Pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 */
public class a228 {

    // j 指向连续区间的最后一个元素，i 指向连续区间的开头元素
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {

            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;

            if (i == j)
                res.add(nums[i] + "");
            else
                res.add(nums[i] + "->" + nums[j]);

            i = j + 1;
        }

        return res;
    }
}
