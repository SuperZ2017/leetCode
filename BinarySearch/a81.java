package BinarySearch;

/**
 * 搜索旋转排序数组，存在重复的元素
 */
public class a81 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int end = nums.length - 1;
        int start = 0, mid;

        while (start <= end){
            mid = (end + start) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (target <= nums[mid] && nums[start] <= target)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int a = 9;
        char b = '1';
        System.out.println(b);
    }
}
