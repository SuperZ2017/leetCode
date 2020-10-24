package jianzhioffer;

/**
 * 求 1 + 2 + ... + n
 */
public class b64 {

    int res = 0;
    public int sumNums(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
