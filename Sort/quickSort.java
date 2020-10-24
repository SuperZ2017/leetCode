package Sort;

import java.util.Arrays;

public class quickSort {

    public static void quickSort (int[] arr, int low, int high) {
        int i, j, tmp, t;
        i = low;
        j = high;
        if (low > high)
            return;

        //基准
        tmp = arr[low];
        while (i < j) {
            //  从右往左，找到第一个比基准小的数
            while (tmp < arr[j] && i < j)
                j--;
            //  从左往右，找到第一个比基准大的数
            while (tmp >= arr[i] && i < j)
                i++;
            // 交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        arr[low] = arr[i];
        arr[i] = tmp;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);

    }



    public static void main(String[] args) {
        int[] arr = {1,7,9,0,2,9};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
