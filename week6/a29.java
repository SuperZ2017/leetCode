package week6;

public class a29 {

    public static int divide(int dividend, int divisor) {
        int symbol = ((long)dividend > 0 && (long)divisor > 0) || ((long)dividend < 0 && (long)divisor < 0) ? 1 : -1;
        if (Math.abs((long)dividend) < Math.abs((long)divisor))
            return 0;
        else if (Math.abs((long)dividend) == Math.abs((long)divisor))
            return symbol;
        if (divisor==1)
            return dividend;
        if (divisor==-1) {
            if (Math.abs(dividend)==dividend)
                return Integer.MAX_VALUE;
            else
                return symbol * (Math.abs(dividend)/1);
        }

        int count = 0;
        long a = Math.abs((long)dividend);  // a/b
        long b = Math.abs((long)divisor);
        long temp = b;
        while (a > temp) {
            temp <<= 1;
            count++;
        }

        long diff = a - (temp >> 1);
        double result = Math.pow(2, count-1);
        while (diff >= b) {
            diff -= b;
            result++;
        }
        return symbol>0?(int)result:-(int)result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10,3));
    }
}
