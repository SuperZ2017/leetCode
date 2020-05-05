package backtrack;

import java.util.*;

/**
 * 组合
 */
public class a77 {

//    public static void main(String[] args) {
//        System.out.println(combine(4, 2));
//    }

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0)
            return res;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }


    //    static List<List<Integer>> res = new LinkedList<>();
//    public static List<List<Integer>> combine(int n, int k) {
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(n, k, track);
//        return res;
//    }
//
//    static void backtrack(int n, int k, LinkedList<Integer> track) {
//        if (track.size() == k) {
//            res.add(new LinkedList<>(track));
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (track.contains(i)) {
//                continue;
//            }
//            boolean flag = false;
//            for (int j = 0; j < track.size(); j++) {
//                if (i < track.get(j)) {
//                   flag = true;
//                   break;
//                }
//            }
//            if (flag)
//                continue;
//            flag = false;
//            track.add(i);
//            backtrack(n, k, track);
//            track.removeLast();
//        }
//    }
}
