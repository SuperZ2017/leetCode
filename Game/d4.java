package Game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class d4 {

//    public static boolean kLengthApart(int[] nums, int k) {
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (1 == nums[i])
//                list.add(i);
//        }
//
//        for (int j = 1; j < list.size(); j++) {
//            if (list.get(j) - list.get(j-1) < k + 1)
//                return false;
//        }
//
//        return true;
//    }

    public static boolean kLengthApart(int[] nums, int k) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index == 0 && nums[i] == 1) {
                index = i;
            } else if (nums[index] == 1 && nums[i] == 1) {
                if (i - index < k + 1)
                    return false;
                index = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,0,1};
        int k = 2;
        System.out.println(kLengthApart(nums, k));
    }
}
