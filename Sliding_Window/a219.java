package Sliding_Window;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素 2
 */
public class a219 {

    // TODO review
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;

            set.add(nums[i]);
            // 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
