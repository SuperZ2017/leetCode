package BinarySearch;

/**
 * 求根号 2，保留小数点后 10 位
 */
public class d1 {

    public static void squareTwo() {
        double frequency = 0.0000000001;
        double l = 1.4;
        double r = 1.5;
        while (r - l > frequency) {
            double mid = (r + l) / 2.0;
            if (mid * mid > 2) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.println(l);
        String s = l + "";
        System.out.println(Double.parseDouble(s.substring(0, 12)));
//        return Double.parseDouble(s.substring(0, 12));
    }

    public static void main(String[] args) {
        squareTwo();
    }

}
