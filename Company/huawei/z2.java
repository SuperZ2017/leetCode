package Company.huawei;

import java.util.*;
// https://www.nowcoder.com/question/next?pid=1088888&qid=36829&tid=32271561
public class z2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int total = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            Set<Integer> set = new LinkedHashSet<>();
            list.stream().forEach(j -> set.add(j));
            set.stream().forEach(k -> System.out.println(k));
        }
    }
}
