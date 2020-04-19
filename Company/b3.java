package Company;

import java.util.*;

public class b3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i+1, sc.nextInt());

        int m = sc.nextInt();
        for (int j = 0; j < m; j++) {
            int count = 0;
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();

            for (int x = l; x <= r; x++) {
                if (map.get(x) == k)
                    count++;
            }

            list.add(count);
        }

        list.stream().forEach(i -> System.out.println(i));
    }
}
