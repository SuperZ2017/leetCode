package jianzhioffer;

/**
 * 0～n-1中缺失的数字
 */
public class b53 {

    public int missingNumber(int[] nums) {
        int r = nums.length - 1;
        int l = 0;

        while (l <= r) {

            int mid = (l + r) >>> 1;

            if (nums[mid] == mid)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return l;
    }
}
