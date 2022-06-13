package Double_Pointer;

import java.util.Arrays;

/**
 * 有效三角形的个数
 */
public class a611 {

    // TODO review
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    cnt += r - l; // 需要证明的
                    r--;
                } else {
                    l++;
                }
            }
        }

        return cnt;
    }
}
