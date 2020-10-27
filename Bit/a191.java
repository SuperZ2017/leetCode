package Bit;

/**
 * 二进制中 1 的个数
 */
public class a191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }

        return res;
    }
}
