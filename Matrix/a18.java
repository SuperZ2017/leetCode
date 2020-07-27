package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class a18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        Arrays.sort(nums);
        if (nums[0] > target)
            return res;

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a-1])
                continue;

            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b-1])
                    continue;

                int i = b + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[a] + nums[b] + nums[i] + nums[j];
                    if (sum > target) {
                        while (i < j && nums[j] == nums[j-1])
                            j--;
                        j--;
                    } else if (sum < target) {
                        while (i < j && nums[i] == nums[i+1])
                            i++;
                        i++;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[i], nums[j])));
                        while (i < j && nums[i] == nums[i+1])
                            i++;
                        i++;
                        while (i < j && nums[j] == nums[j-1])
                            j--;
                        j--;
                    }
                }
            }
        }

        return res;
    }
}
