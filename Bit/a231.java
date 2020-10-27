package Bit;

/**
 * 2 的幂
 */
public class a231 {

    /**
     *   n 为 2 的幂，则 n 二进制最高位为 1，其余所有位为 0；
     *              n−1 二进制最高位为 0，其余所有位为 1；
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
