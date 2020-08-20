package week6;


import java.util.Stack;

/**
 * 接雨水
 */
public class a42 {

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

    public int trap_3(int[] height) {
        int sum = 0;
        Stack<Integer> stack =  new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; // 取出要出栈的元素
                stack.pop();
                if (stack.isEmpty())
                    break;

                int distance = current - stack.peek() - 1; // 两堵墙之前的距离
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }

            stack.push(current); //当前指向的墙入栈
            current++;
        }

        return sum;
    }

}
