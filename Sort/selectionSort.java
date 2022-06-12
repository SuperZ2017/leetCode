package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 每一轮选择最小元素交换到未排序部分的开头
 * <p>
 * 优点：交换次数少，O(N^2), O(1)
 */
public class selectionSort {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for (int i = 0; i < len - 1; i++) {
            // 选择区间 [i, len - 1] 里面最小的元素的索引，交换到下标 i
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex)
                swap(nums, i, minIndex);
        }

        return nums;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        selectionSort sort = new selectionSort();
        int[] res = sort.sortArray(nums);
//        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(nums));
    }

}
