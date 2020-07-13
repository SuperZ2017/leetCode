package Matrix;

import java.util.*;

// 两个数组的交集2
public class a350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int idx1 = 0, idx2 = 0, idx = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else if (nums1[idx1] == nums2[idx2]) {
                res[idx] = nums1[idx1];
                idx1++;
                idx2++;
                idx++;
            }
        }

        return Arrays.copyOfRange(res, 0, idx);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.merge(num, 0, (p,v) -> p + v);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }
}
