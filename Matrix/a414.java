package Matrix;


/**
 * 数组中第三大元素
 */
public class a414 {

    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;

        for (long num : nums) {
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax && num != secondMax && num != max) {
                thirdMax = num;
            }
        }

        if (thirdMax == Long.MIN_VALUE)
            return (int)max;
        return (int)thirdMax;
    }
}
