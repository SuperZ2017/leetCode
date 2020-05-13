package Double_Pointer;

/**
 * 删除数组中不重复的元素 2
 */
public class a80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        if (nums.length <= 2)
            return nums.length;

        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i-1]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
