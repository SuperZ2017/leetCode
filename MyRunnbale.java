import java.util.*;

public class MyRunnbale {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(get(n));
        }

    }

    static int get(int month) {
        if (month <= 0)
            return 0;

        if (month == 1 || month == 2)
            return 1;

        return get(month - 1) + get(month - 2);
    }

}
