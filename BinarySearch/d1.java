package BinarySearch;

/**
 * 求 根号 2，保留小数点后 10 位
 */
public class d1 {

    public double squareTwo() {
        final double frequency = 0.0000000001;
        double l = 1.4;
        double r = 1.5;
        while (r - l > frequency) {
            double mid = (r + l) / 2.0;
            if (mid * mid > 2) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        String s = l + "";
        return Double.parseDouble(s.substring(0, 12));
    }

}
