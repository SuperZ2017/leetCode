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

        //  1.定义[0,index] 是修改后的满足要求的数组区间
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            // 保证长度为 2
            if (nums[j] != nums[i - 2 + 1]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) nums[i++] = n;
        }
        return i;
    }
}
