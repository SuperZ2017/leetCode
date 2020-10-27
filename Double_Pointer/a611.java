package Double_Pointer;

import java.util.Arrays;

/**
 * 有效三角形的个数
 */
public class a611 {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    cnt += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return cnt;
    }
}
