package Heap;

import java.util.*;

/**
 * 前 k 个高频元素
 */
public class a347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        Arrays.stream(nums).forEach(i -> map.merge(i, 1, (p, o) -> p + o));
        for (Integer key : map.keySet())
            queue.add(key);

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty() && k-- > 0)
            res.add(queue.poll());

        return res;
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        Arrays.stream(nums).forEach(i -> map.merge(i, 1, (p, o) -> p + o));
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i++ < k)
                queue.add(key);
            else {
                queue.add(key);
                queue.poll();

            }
        }

        List<Integer> res = new ArrayList<>();
        int[] a = new int[queue.size()];
        int j = 0;
        while (!queue.isEmpty()) {
            a[j] = queue.poll();
            if (!queue.isEmpty())
                j++;
        }

       return a;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,3,3,4,5,7,4,7,7,8,8,8,9,9,9,7,8};
        int k = 2;
        topKFrequent1(nums, k);
        System.out.println(1);
    }
}
