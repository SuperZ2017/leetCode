package Bit;

/**
 * 数组中数字出现的次数
 */
public class b56 {

    /**
     * 异或满足交换律，第一步异或，相同的数其实都抵消了，剩下两个不同的数。
     * 这两个数异或结果肯定有某一位为1，不然都是0的话就是相同数。
     * 找到这个位，不同的两个数一个在此位为0，另一个为1。
     * 按此位将所有数分成两组，分开后各自异或，相同的两个数异或肯定为0（而且分开的时候，两个数必为一组）。
     * 剩下的每组里就是我门要找的数。
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums)
            k ^= num;
        int mask = 1;
        while ((k & mask) == 0)
            mask <<= 1;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums)
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;   // 更新第 j 位
                num >>>= 1;     // 第 j 位 --> 第 j + 1 位
            }

        int res = 0, m = 3;

        for(int i = 0; i < 32; i++) {
            counts[i] %= 3; // 得到 只出现一次的数字 的第 (31 - i) 位
        }

        for(int i = 0; i < counts.length; i++) {
            res <<= 1; // 左移 1 位
            res |= counts[31 - i]; // 恢复第 i 位的值到 res
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 3};
        System.out.println(singleNumber(nums));
    }
}
