package Math;

/**
 * 数值的整数次方
 */
public class b16 {

    public static double myPow(double x, int n) {

        if (n == 0)
            return 1;

        if (n < 0)
            return 1 / myPow(x, -n);

        // n为奇数多计算一次，为偶数就是最后一次 myPow(x, n-1)是1
        if (n % 2 == 1)
            return x * myPow(x, n - 1);

        // n除2
        return myPow(x * x, n >> 1);
    }

    public static void main(String[] args) {
        System.out.println(myPow(3,2));
    }
}
