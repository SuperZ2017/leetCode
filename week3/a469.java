package week3;

public class a469 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums1.length == 0)
            return res;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    if (j + 1 < nums2.length - 1 && nums2[j] < nums2[j + 1])
                        nums1[i] = nums1[j + 1];
                    else
                        nums1[i] = -1;

            }
        }
        return res;
    }
}
