package Game;

import java.util.*;

public class d5402 {

//    public static int longestSubarray(int[] nums, int limit) {
//        int maxLen = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = i; j < nums.length; j++) {
//                list.add(nums[j]);
//                if (isValid(list ,limit)) {
//                    maxLen = Math.max(maxLen, list.size());
//                }
//            }
//
//        }
//
//        return maxLen;
//    }
//
//    private static boolean isValid(List<Integer> list, int limit) {
//        Object[] arr1 = list.toArray();
//        int[] arr = new int[arr1.length];
//        for (int i = 0; i < arr.length; i++)
//            arr[i] = (int) arr1[i];
//        Arrays.sort(arr);
//        if (Math.abs(arr[0] - arr[list.size()-1]) <= limit) {
//            return true;
//        }
//
//        return false;
//    }

    public static int longestSubarray(int[] nums, int limit) {
        Queue<Integer> queueMin = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> queueMax = new PriorityQueue<>();
        int left = 0, right = 0, max = 0;
        while (right < nums.length) {
            queueMin.add(nums[right]);
            queueMax.add(nums[right]);
            while (!queueMin.isEmpty() && nums[queueMax.peek()] - nums[queueMin.peek()] > limit) {
                queueMin.remove(left);
                queueMax.remove(left++);
            }
            max = Math.max(max, right-left+1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
    }
}
