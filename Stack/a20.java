package Stack;

import java.util.*;

/**
 * 有效的括号
 */
public class a20 {

    // 只入栈左括号，和其匹配
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)) {
                stack.push(tmp);
            } else if (stack.isEmpty() || tmp != map.get(stack.pop())) {
                return false;
            }
        }

        //防止 (((、[({等情况出现
        if (stack.isEmpty())
            return true;

        return false;
    }
}
