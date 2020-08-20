package BinarySearch;

/**
 * 寻找重复数
 */
public class a287 {

    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid)
                    cnt++;
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
