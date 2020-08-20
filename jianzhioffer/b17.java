package jianzhioffer;

/**
 * 打印从 1 到最大的 n 位数
 */
public class b17 {

    public static int[] printNumbers(int n) {
        int x = (int) Math.pow(10, n);
        int[] res = new int[x - 1];
        for (int i = 0; i < x - 1; i++)
            res[i] = i + 1;

        return res;
    }
}
