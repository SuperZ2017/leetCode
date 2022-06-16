package Math;

/**
 * Excel表列名称
 */
public class a168 {

    // todo review
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;

            if (c == 0) {
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((char) ('A' + 25));
    }
}
