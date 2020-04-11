package Company.huawei;

import java.util.*;


// https://www.nowcoder.com/test/question/f9533a71aada4f35867008be22be5b6e?pid=710802&tid=32278708
public class z4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < a; i++) {
                queue.addLast(i);
            }
            int t = 0;
            while (queue.size() != 1) {
                if (t != 0 && t % 2 == 0) {
                    queue.poll();
                }
                queue.offer(queue.poll());
                ++t;
            }
            System.out.println(queue.poll());
        }
    }
}
