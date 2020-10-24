package Sliding_Window;

/**
 * 长度最小的子数组
 */
public class a209 {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = 10000;
        int left = 0;
        int sum = 0;
        for(int i = 0;i < n; i++){
            sum += nums[i];
            while(sum >= s){
                //i+1-left 是当前子数组的长度
                ans = Math.min(ans, (i + 1 - left));
                sum -= nums[left++];
            }
        }
        return (ans != 10000 ? ans : 0);
    }
}
