package Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 数组的交集 结果无重复
public class a349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        int idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else if (nums1[idx1] == nums2[idx2]) {
                set.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
        }
        Object[] num = set.toArray();
        int[] res = new int[set.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int)num[i];
        }

        return res;

    }

}
