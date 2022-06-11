package Greedy;

import java.util.Arrays;

/**
 * 分发糖果
 */
public class a135 {

    public int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的糖果数加 1；
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;

        int count = left[ratings.length - 1];

        // 从右往左遍历一遍，如果左边孩子的评分比右边的高，
        // 且左边孩子当前的糖果数不大于右边孩子的糖果数，则左边孩子的糖果数更新为右边孩子的糖果数加 1。
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }

        return count;
    }

}
