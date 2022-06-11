package Sort;

import java.util.Arrays;

public class quickSort {

    // ps 结束条件、先从右往左，再从左往右
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, tmp, t;
        i = low;
        j = high;
        if (low > high)
            return;

        //基准
        tmp = arr[low];
        while (i < j) {
            //  从右往左，找到第一个比基准小的数，必须先进行这一步
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
        int[] arr = {11, 1, 7, 9, 0, 2, 9, 11};
//        select(arr);
//        insert(arr);
//        mergeSort(arr, 0, arr.length - 1);
//        quick(arr, 0, arr.length - 1);
        heap(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heap(int[] arr) {
        int N = arr.length;
        heapify(arr);

        for (int i = N - 1; i >= 0;) {
            sortHelper.swap(arr, 0, i);
            i--;
            siftDown(arr, 0, i);
        }
    }

    private static void heapify(int[] arr) {
        int N = arr.length;
        for (int i = N / 2; i >= 0; i--) {
            siftDown(arr, i, N - 1);
        }
    }


    private static void siftDown(int[] arr, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > arr[k]) {
                sortHelper.swap(arr, j, k);
            } else {
                break;
            }

            k = j;
        }
    }


    private static void quick(int[] arr, int low, int high) {
        if (low > high) return;
        int i = low, j = high, tmp = arr[low];

        while (i < j) {
            while (arr[j] > tmp && i < j) j--;
            while (arr[i] <= tmp && i < j) i++;
            if (i < j) sortHelper.swap(arr, i, j);
        }

        sortHelper.swap(arr, i, low);
        quick(arr, low, i - 1);
        quick(arr, i + 1, high);
    }


    private static void mergeSort(int[] arr, int low, int high) {
        if (low == high)
            return;

        int mid = (low + high) >>> 1;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }


    private static void merge(int[] arr, int low, int mid, int high) {
        int[] helper = new int[high - low + 1];
        int pos1 = low, pos2 = mid + 1, idx = 0;

        while (pos1 <= mid && pos2 <= high) {
            if (arr[pos1] >= arr[pos2])
                helper[idx++] = arr[pos2++];
            else
                helper[idx++] = arr[pos1++];

        }

        while (pos1 <= mid)
            helper[idx++] = arr[pos1++];

        while (pos2 <= high)
            helper[idx++] = arr[pos2++];

        for (int j = 0; j < helper.length; j++) {
            arr[low++] = helper[j];
        }
    }


    private static void insert(int[] arr) {
        int N = arr.length;

        for (int i = 1; i < N; i++) {

            int tmp = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }


    private static void bubble(int[] arr) {
        int N = arr.length;

        for (int i = N - 1; i >= 0; i--) {

            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    sortHelper.swap(arr, j, j + 1);
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    private static void select(int[] arr) {
        int N = arr.length;

        for (int i = 0; i < N; i++) {
            int min = i;

            for (int j = i + 1; j < N; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            sortHelper.swap(arr, min, i);

        }

        System.out.println(Arrays.toString(arr));
    }


}
