package Heap;

import java.util.*;

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

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,5,7,4,7,7,8,8,8,9,9,9};
        int k = 1;
        List<Integer> re = topKFrequent(nums, k);
        System.out.println(re);
    }
}
