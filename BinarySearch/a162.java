package BinarySearch;

/**
 * 寻找峰值
 */
public class a162 {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) { //如果 mid 较大，则左侧存在峰值
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,9,8,7,6};
//        System.out.println(findPeakElement(arr));
        String version = "7.5.2.4";
        String[] num1 = version.split("\\.");
        System.out.println(1);
    }
}
