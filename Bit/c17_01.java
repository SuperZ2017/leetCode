package Bit;


/**
 * 位运算模拟加法
 */
public class c17_01 {

    // 递归
    public int add(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    // 迭代
    public int add1(int a, int b) {
        while (b != 0) {
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
