package Sort;

/**
 * 插入排序
 *
 * 每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组
 *
 * 稳定排序，在接近有序的情况下，表现优异
 */
public class insertionSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }

        return nums;
    }
}
