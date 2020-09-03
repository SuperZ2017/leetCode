package jianzhioffer;


import java.util.Arrays;

/**
 *  数组中的逆序对
 */
public class b51 {

    public static void main(String[] args) {
        int[] arr = {1,4,6,2,3};
        mergeSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }

    static int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public static void mergeSort(int[] a, int start, int end) {
//        if (start == end) return;
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int p1 = left, p2 = mid + 1, k = left;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                temp[k++] = a[p1++];
            else {
                temp[k++] = a[p2++];
                count += (mid - p1 + 1);
            }
        }

        while (p1 <= mid)
            temp[k++] = a[p1++];
        while (p2 <= right)
            temp[k++] = a[p2++];

        for (int i = left; i <= right; i++)
            a[i] = temp[i];
    }
}
