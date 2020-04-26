package Turing;

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

        while (j >= 0)
            A[j] = B[j--];
    }
}
