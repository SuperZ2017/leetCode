package Matrix;

/**
 * 缺失的第一个正数
 * <p>
 * hard
 */
public class a41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return n + 1;
    }
}
