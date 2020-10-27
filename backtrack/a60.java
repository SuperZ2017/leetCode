package backtrack;

import java.util.LinkedList;

/**
 * 第 K个排列
 */
public class a60 {

    int count;
    boolean[] used;
    LinkedList<Integer> res;

    public String getPermutation(int n, int k) {
        used = new boolean[n];
        res = new LinkedList<>();
        backTrack(n, k);
        StringBuilder sb = new StringBuilder();
        for (Integer i : res)
            sb.append(i);

        return sb.toString();
    }

    void backTrack(int n, int k) {
        if (res.size() == n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i - 1]) {
                used[i - 1] = true;
                res.add(i);
                backTrack(n, k);
                if (count == k)
                    return;
                used[i - 1] = false;
                res.removeLast();
            }
        }

        return;
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        a60 a = new a60();
        a.getPermutation(n, k);
    }

}
