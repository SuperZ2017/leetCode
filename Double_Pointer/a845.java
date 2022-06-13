package Double_Pointer;

/**
 * 数组中的最长山脉
 */
public class a845 {

    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0, l = 0;
        // 因为山脉的长度至少为 3；其次我们需要保证 A[l] < A[l + 1]
        while (l + 2 < n) {
            int r = l + 1;
            if (A[l] < A[l + 1]) {
                while (r + 1 < n && A[r] < A[r + 1]) {
                    r++;
                }
                if (r + 1 < n && A[r] > A[r + 1]) {
                    while (r + 1 < n && A[r] > A[r + 1]) {
                        r++;
                    }
                    ans = Math.max(ans, r - l + 1);
                } else {
                    r++;
                }
            }
            l = r;
        }
        return ans;
    }
}
