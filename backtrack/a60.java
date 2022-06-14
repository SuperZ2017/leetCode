package backtrack;

import java.util.LinkedList;

/**
 * 第 K 个排列
 */
public class a60 {

    int count;
    StringBuilder res = new StringBuilder();
    boolean[] used;

    public String getPermutation(int n, int k) {
        used = new boolean[n];
        backTrack(n, k);
        return res.toString();
    }

    void backTrack(int n, int k) {
        if (res.length() == n) {
            count++;
            return;
        }

        // ps：这里递归前进主要是通过 !used[i - 1]，n 和 k 没有意义
        for (int i = 1; i <= n; i++) {
            if (used[i - 1] == false) {
                used[i - 1] = true;
                res.append(i);
                backTrack(n, k);
                if (count == k)
                    return;
                used[i - 1] = false;
                res.deleteCharAt(res.length() - 1);
            }
        }
    }



    public static void main(String[] args) {
        int n = 3, k = 3;
        a60 a = new a60();
        a.getPermutation(n, k);
    }

}
