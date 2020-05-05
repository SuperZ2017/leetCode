package BinarySearch;

/**
 * 搜索旋转排序数组，不存在重复的元素
 */
public class a33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int end = nums.length - 1;
        int start = 0;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] == target)
                return mid;

            // start 到 mid 有序
            // 先根据 nums[mid] 与 nums[start] 的关系判断 mid 是在左段还是右段
            if (nums[start] <= nums[mid]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 start 和 end
                if (target >= nums[start] && target <= nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target >= nums[mid] && target <=nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}
