package Sort;

public class quickSort {

    public static void quickSort (int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high)
            return;
        i = low;
        j = high;
        temp = arr[low];

        while (i < j) {

            while (temp < arr[j] && i < j) {
                j--;
            }

            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

            //最后将基准为与i和j相等位置的数字交换
            arr[low] = arr[i];
            arr[i] = temp;

            quickSort(arr, low, j - 1);
            quickSort(arr, j + 1, high);

        }
    }
}
