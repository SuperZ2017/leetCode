package BinarySearch;

/**
 * 寻找旋转排序数组中的最小值 II
 */
public class a154 {
    /**
     * 当 nums[mid] > nums[right]时，mid 一定在第 1 个排序数组中，i 一定满足 mid < i <= right，因此执行 left = mid + 1；
     * 当 nums[mid] < nums[right] 时，mid 一定在第 2 个排序数组中，i 一定满足 left < i <= mid，因此执行 right = mid；
     * 当 nums[mid] == nums[right] 时，right = right - 1
     */

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                right = right - 1;
        }
        return nums[left];
    }
}
