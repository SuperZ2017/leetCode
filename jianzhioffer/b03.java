package jianzhioffer;

/**
 * 数组中重复的数字
 */
public class b03 {

    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i) {
                int temp = nums[i];

                if (temp == nums[temp])
                    return temp;

                nums[i] = nums[temp];
                nums[temp] = temp;

            }
        }

        return -1;
    }
}
