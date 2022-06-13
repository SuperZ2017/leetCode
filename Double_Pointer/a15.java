package Double_Pointer;

import java.util.*;

/**
 * 三数之和
 */
public class a15 {

    // TODO review
    public List<List<Integer>> second(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len; i++) {

            if (nums[i] > 0)
                return result;

            // 去重，跳过重复的
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int cur = nums[i];
            int L = i + 1, R = len - 1;

            // 举例 [-1, 0, 0, 1, 1]
            while (L < R) {
                int temp = cur + nums[L] + nums[R];
                if (temp == 0) {
                    result.add(Arrays.asList(cur, nums[L], nums[R]));
                    while (L < R && nums[L + 1] == nums[L])
                        ++L;
                    while (L < R && nums[R - 1] == nums[R])
                        --R;
                    ++L;
                    --R;
                } else if (temp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2)
            return Collections.emptyList();

        // 答案不包括重复的元素，用于去重
        Set<List<Integer>> sum = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = map.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    sum.add(list);
                } else {
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(sum);
    }
}
