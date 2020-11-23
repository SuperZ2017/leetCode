package Double_Pointer;

/**
 * 颜色分类
 */
public class a75 {

    public void sortColors(int[] nums) {
        // p0 指向 0 的最右边界，p2 指向 2 的最左边界，curr 指向当前元素
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0 个和第 curr 个元素
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第 p2 个和第 curr 个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else
                curr++;
        }
    }
}
