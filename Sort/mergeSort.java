package Sort;
import java.util.Arrays;


/**
 * 归并排序
 *
 * 稳定排序
 */
public class mergeSort {

    public static void mergeSort (int[] arr, int low, int high) {
        if (low == high) return;
        int mid = low + ((high - low) >> 1);
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    public static void merge (int[] arr, int low, int mid, int high) {
        int[] help = new int[high - low + 1];
        int i = 0;
        int pos1 = low;
        int pos2 = mid + 1;
        while (pos1 <= mid && pos2 <= high) {
            if (arr[pos1] <= arr[pos2])
                help[i++] = arr[pos1++];
            else if (arr[pos1] > arr[pos2])
                help[i++] = arr[pos2++];
        }

        while (pos1 <= mid)
            help[i++] = arr[pos1++];
        while (pos2 <= high)
            help[i++] = arr[pos2++];
        for (int j = 0; j < help.length; j++) {
            arr[low + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,7,9,0,2,9};
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
