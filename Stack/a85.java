package Stack;

import java.util.Stack;

public class a85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            // 遍历每一行，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1')
                    heights[col] += 1;
                else
                    heights[col] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i])
                mono_stack.pop();
            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
