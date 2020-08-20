package jianzhioffer;

/**
 * 二进制中1的个数
 */
public class b15 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }

        return res;
    }
}
