package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Supplier;

/**
 * 数组中的第 K 个最大元素
 */
public class a215 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k && !queue.isEmpty()) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.add(num);
        }
        while (k != 0) {
            queue.poll();
            k--;
        }

        return queue.poll();
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 9, 5, 3, 1, 2, 4, 5, 5, 6};
//        int k = 4;
//        System.out.println(findKthLargest(arr, k));

//        int max = printMax( () -> {
//            Arrays.sort(arr);
//
//            return arr[arr.length - 1];
//        });

        Arrays.stream(arr).filter(i -> i > 2).sorted().forEach(System.out::println);

//        System.out.println("return max = " + max);
    }


    public static int printMax(Supplier<Integer> supplier) {
        System.out.println("aa");
        int max = supplier.get();
        System.out.println("max = " + max);
        return max;
    }
}
