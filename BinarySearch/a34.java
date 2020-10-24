package BinarySearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class a34 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1,-1};
        if (nums.length == 1)
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        int start = leftSearch(nums, target);
        int end = rightSearch(nums, target);
        return new int[]{start, end};
    }

    public static int leftSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                r = mid - 1;
        }

        if (l == nums.length)
            return -1;
        return nums[l] == target ? l : -1;
    }

    public static int rightSearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if (nums[mid] == target)
                l = mid + 1;
            else if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
        }

        if (r < 0)
            return -1;
        return nums[r] == target ? r : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int target = 6;
        System.out.println(leftSearch(arr, target));
    }
}
