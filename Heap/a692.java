package Heap;

import java.util.*;

/**
 * 前K个高频单词
 */
public class a692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words)
            count.merge(word, 1, (p, o) -> p + o);

        List<String> candidates = new ArrayList<>(count.keySet());
        Collections.sort(candidates, (w1, w2) ->
                count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words)
            count.merge(word, 1, (p, o) -> p + o);

        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) ->
                count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2));

        for (String word : count.keySet()) {
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty())
            ans.add(heap.poll());

        Collections.reverse(ans);
        return ans;
    }


}
