package week2;

public class a50 {

    public static void main(String[] args) {
        System.out.println(myPow(2,5));
    }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;

        // 递归调用结束
        if (n == 1)
            return x;

        double result = myPow(x, n >> 1);
        result *= result;

        // n为奇数，则多乘一次x
        if (n % 2 == 1)
            result *= x;

        return result;
    }

    public double myPow_2(double x, int n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 1 / myPow_2(x, -n);

        if (n % 2 == 1)
            return x * myPow_2(x, n - 1);

        return myPow_2(x * x, n >> 1);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow_3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }




}
