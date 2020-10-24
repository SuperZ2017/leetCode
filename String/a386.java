package String;

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
}
