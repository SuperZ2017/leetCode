package week2;

import java.util.*;

public class a169 {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num ->
                map.merge(num, 1, Integer::sum));

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int majorityElementRec(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int majorityElementRec(int[] nums, int lo, int ho) {
        if (lo == ho)
            return nums[lo];

        int mid = (ho - lo) >> 1 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid, ho);

        if (left == right)
            return left;

        int leftCount = CountInRange(nums, left, lo, mid);
        int rightCount = CountInRange(nums, right, mid, ho);
        return leftCount > rightCount ? left : right;
    }

    private int CountInRange(int[] nums, int num, int lo, int ho) {
        int count = 0;
        for (int i = lo; i <= ho; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


}
