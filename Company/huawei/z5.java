package Company.huawei;

import java.util.*;

// https://www.nowcoder.com/question/next?pid=710802&qid=26011&tid=32278708

public class z5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            List<Character> list = new ArrayList<>();
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (list.contains(ch[i]))
                    continue;
                else
                    list.add(ch[i]);
            }

            StringBuilder sb = new StringBuilder();
            list.stream().forEach(o -> sb.append(o));
            System.out.println(sb);
        }

    }
}
