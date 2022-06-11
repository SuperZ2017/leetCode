package Sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class heapSort {

    public void sortArray(int[] nums) {
        int len = nums.length;
        heapify(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
    }

    void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = len / 2 这个位置开始逐层下移
        for (int i = len / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            // 如果左孩子 < 右孩子，则指向右孩子
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            // 从孩子节点再调整
            k = j;
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        heapSort sort = new heapSort();
        sort.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
