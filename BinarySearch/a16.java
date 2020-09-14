package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最接近的三数之和
 */
public class a16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int start = i+1, end = nums.length-1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target-sum) < Math.abs(target-ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        for (int i = 1; i <= 10; ++i) {
//            if ((i & 1) != 1)
//                System.out.println(i);
//        }

//        int count = 10;
//        List<Integer> list = new ArrayList<>(10);
//        for (int i = 1; i <= count; i++)
//            list.add(i);
//
//        Integer[] arr = new Integer[10];
//        list.toArray(arr);
//        for (int i : arr)
//            System.out.println(i);

        List a1 = new ArrayList();
        a1.add(12);
        a1.add("13");
        a1.add('4');
        a1.add(new String("hello"));
        a1.stream().forEach(i -> System.out.println(i));
    }
}
