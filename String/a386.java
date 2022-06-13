package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 字典序排数
 */
public class a386 {

    public List<Integer> lexicalOrder(int n) {
        Set<String> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(String.valueOf(i));
        }

        return set.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    // todo review
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ret = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }


}
