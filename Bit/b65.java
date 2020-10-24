package Bit;


/**
 * 不用加减乘除做加法
 */
public class b65 {

    public int add(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    public int add1(int a, int b) {
        while (b != 0) {

            int sum = a ^ b;
            int carrySum = (a & b) << 1;
            a = sum;
            b = carrySum;
        }

        return a;
    }

}
