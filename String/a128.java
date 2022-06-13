package String;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列, hard
 */
public class a128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int longestStreak = 0;

        for (int num : set) {

            // 如果不存在 比它小 1 的数，就从它开始
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
