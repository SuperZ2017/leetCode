package jianzhioffer;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class b21 {

    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {

            while (l < r && (nums[l] % 2 == 1))
                l++;

            while (l < r && (nums[r] % 2 == 0))
                r--;

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;r--;
        }

        return nums;
    }
}
