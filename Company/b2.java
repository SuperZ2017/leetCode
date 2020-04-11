package Company;

import java.util.Arrays;
import java.util.Scanner;

public class b2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] H = new int[N];
            for (int i = 0; i < N; i++)
                H[i] = sc.nextInt();
            int left = 0;
            int right = 100000;
            while (left < right) {
                int mid = (right + left) >> 1 -left;
                if (check(mid, H))
                    right = mid;
                else
                    left = mid + 1;
            }

            if (check(left, H))
                System.out.println(left);
            else
                System.out.println(right);
        }
    }

    private static boolean check(int mid, int[] H) {
        for (int i = 0; i < H.length; i++) {
            if (mid <= H[i])
                mid -= H[i] - mid;
            else
                mid += mid - H[i];
            if (mid > 500000)
                return true;
            if (mid < 0)
                return false;
        }
        return true;
    }
}
