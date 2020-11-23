package Double_Pointer;

/**
 * 数组中的最长山脉
 */
public class a845 {

    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0, left = 0;
        // 因为山脉的长度至少为 3；其次我们需要保证 A[left] < A[left + 1]
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    right++;
                }
                if (right + 1 < n && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        right++;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    right++;
                }
            }
            left = right;
        }
        return ans;
    }
}
