package Game;

import java.util.LinkedList;
import java.util.List;

/**
 * 用栈操作构建数组
 */
public class d5404 {

    public static List<String> buildArray(int[] target, int n) {
        List<String> res = new LinkedList<>();

        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (target[j] == i) {
                res.add("push");
                j++;
            } else {
                res.add("push");
                res.add("pop");
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] target = {2,3,4};
        int n = 4;
        System.out.println(buildArray(target, n));
    }
}
