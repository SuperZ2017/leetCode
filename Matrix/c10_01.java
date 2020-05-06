package Matrix;

/**
 * 合并排序的数组
 */
public class c10_01 {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[i+j+1] = B[j--];
            } else {
                A[i+j+1] = A[i--];
            }
        }

        // 因为A和B中总有一个数组先插入完毕，一个数组被剩下。
        // 如果A被剩下，它本来就在数组中且有序，就不用管了。
        // 但如果B被剩下，还需将其一一插入A中。
        while (j >= 0)
            A[j] = B[j--];
    }
}
