package Stack;


import java.util.Stack;

/**
 * 接雨水
 */
public class a42 {

    // todo review 单调 (减) 栈
    public int trap_3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空 并且当前指向的高度 大于 栈顶高度就一直循环，单调递减栈储存可能储水的柱子，当找到一个比前面高的柱子，就可以计算接到的雨水
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int h = height[stack.peek()]; // 取出要出栈的元素
                stack.pop();
                if (stack.isEmpty())
                    break;

                int distance = current - stack.peek() - 1; // 两堵墙之前的距离
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }

            stack.push(current); //当前指向的墙入栈
            current++;
        }

        return sum;
    }

    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            // 找到左侧最大值
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--)
                if (height[j] > max_left)
                    max_left = height[j];
            // 找到右侧最大值
            int max_right = 0;
            for (int k = i + 1; k < height.length; k++)
                if (height[k] > max_right)
                    max_right = height[k];

            int min = Math.min(max_left, max_right);
            if (min > height[i])
                sum += min - height[i];
        }

        return sum;
    }


    public int trap_2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++)
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        for (int i = height.length - 2; i >= 0; i--)
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i])
                sum = sum + (min - height[i]);
        }

        return sum;
    }

    // 如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当
    // 我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）
    public int trap_4(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    ans += left_max - height[left];
                left++;
            } else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    ans += right_max - height[right];
                --right;
            }
        }
        return ans;
    }

//    定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
//
//    定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
//
//    定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。

//    对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
//    无论右边将来会不会出现更大的right_max，都不影响这个结果。 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
}
