package Heap;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
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
        while(k != 0){
            queue.poll();
            k--;
        }

        return queue.poll();
    }


    public static void main(String[] args) {
        int[] arr = {3,2,9,5,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }
}
