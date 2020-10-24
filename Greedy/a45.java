package Greedy;

/**
 * 跳跃游戏2
 */
public class a45 {

    public int jump(int[] nums) {
        int maxPosition = 0, end  = 0, step = 0;
        // 这里有个小细节，因为是起跳的时候就 + 1 了，如果最后一次跳跃刚好到达了最后一个位置，
        // 那么遍历到最后一个位置的时候就会再次起跳，这是不允许的，因此不能遍历最后一个位置
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到范围内最远的距离
            if (i <= maxPosition) {
                maxPosition = Math.max(maxPosition, nums[i] + i);
                //第一次起跳 或 到达跳跃的边界
                if (i == end) {
                    end = maxPosition;
                    step++;
                }
            }

        }

        return step;
    }
}
