package week6;


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

}
