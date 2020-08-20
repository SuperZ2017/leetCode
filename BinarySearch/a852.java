package BinarySearch;

/**
 * 山脉数组的峰顶索引
 *
 */
public class a852 {

    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
