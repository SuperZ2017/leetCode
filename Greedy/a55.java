package Greedy;

/**
 * 跳跃游戏
 */
public class a55 {

    // todo review
    public boolean canJump(int[] nums) {
        int maxPostion = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // i 在本次最远范围内，更新最远的距离
            if (i <= maxPostion) {
                maxPostion = Math.max(maxPostion, nums[i] + i);
                if (maxPostion >= n - 1)
                    return true;
            }

        }

        return false;
    }
}
