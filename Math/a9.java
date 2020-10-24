package Math;

/**
 * 回文数
 */
public class a9 {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int num = x;
        int sum = 0;
        // 反转后比较
        while (num != 0) {
            sum = sum * 10 + num % 10;
            num /= 10;
        }
        return sum == x;
    }

    // 只反转一半
    public boolean isPalindrome1(int x){
        if (x < 0 || x % 10 == 0 && x != 0){
            return false;
        }
        int revertedNumber = 0;
        // 当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
