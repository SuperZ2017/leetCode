package BinarySearch;

/**
 * 旋转数组中的最小值
 */
public class a153 {

    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int l = 0, r = nums.length-1;
        // 有序
        if (nums[0] < nums[r])
            return nums[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid+1])
                return nums[mid+1];

            if (nums[mid-1] > nums[mid])
                return nums[mid];

            if (nums[mid] > nums[0])
                l = mid + 1;
            else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
