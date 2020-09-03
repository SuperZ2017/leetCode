package backtrack;

import data.ListNode;

import java.util.*;

/**
 * 递增子序列
 */
public class a491 {

    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new LinkedList<>();
        backTrack(nums, 0, new LinkedList<>());
        return res;
    }

    void backTrack(int[] nums, int idx, LinkedList<Integer> path) {
        if (path.size() > 1)
            res.add(new LinkedList<>(path));

        // 去掉同层中相同的数字
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;

            set.add(nums[i]);
            if (idx == 0 || nums[i] >= nums[idx - 1]) {
                path.add(nums[i]);
                backTrack(nums, i + 1, path);
                path.removeLast();
            }
        }
    }

    public int findTriangle(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        Arrays.sort(A);
        int count = 0;
        for (int i = A.length - 1; i > 1 ; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (A[left] + A[right] > A[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public int[] getWater(int[] W, int requirement) {
        int left = 0, right = W.length - 1;
        Arrays.sort(W);
        while (left < right) {
            int sum = W[left] + W[right];
            if (sum == requirement) {
                return new int[]{left, right};
            } else if (sum > requirement) {
                right--;
            } else if (sum < requirement) {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}
