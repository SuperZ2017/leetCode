package Matrix;

/**
 * 下一个排列
 */
public class a31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;

        int j = nums.length - 1;
        if (i >= 0) {
            while (j >= 0 && nums[i] >= nums[j])
                j--;
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
