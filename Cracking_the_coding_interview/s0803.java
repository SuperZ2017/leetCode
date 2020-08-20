package Cracking_the_coding_interview;

/**
 * 魔术索引
 */
public class s0803 {

    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    private int getAnswer(int[] nums, int left, int right) {
        if (left > right)
            return -1;

        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1)
            return leftAnswer;
        else if (nums[mid] == mid)
            return mid;

        return getAnswer(nums, mid + 1, right);

    }


}
