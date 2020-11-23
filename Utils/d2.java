package Utils;

import java.util.*;

/**
 * 中缀表达式转后缀表达式
 */
public class d2 {

    // 表达式栈
    Stack<String> vals;
    // 操作符栈
    Stack<Character> ops;

    public  List<String> convert(String expr) {
        ops = new Stack<>();
        vals = new Stack<>();
        char[] exprs = expr.toCharArray();
        int n = exprs.length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            // 循环接受数字
            StringBuilder sb = new StringBuilder();
            while (i < n && Character.isDigit(exprs[i])){
                sb.append(exprs[i++]);
            }
            if (i <= n && sb.length() != 0) {
//                num = Integer.valueOf(sb.toString());
                i--;
            }

            if (exprs[i] == '+' || exprs[i] == '-')
                operationOpStack(exprs[i], 1);
            else if (exprs[i] == '*' || exprs[i] == '/')
                operationOpStack(exprs[i], 2);
            else if (exprs[i] == '(')
                ops.push(exprs[i]);
            else if (exprs[i] == ')')
                operationParen();
            else
                vals.push(sb.toString());
        }

        while (!ops.isEmpty()) {
            vals.push(String.valueOf(ops.pop()));
        }

        List<String> res = new ArrayList<>();
        while (!vals.isEmpty()) {
            res.add(vals.pop());
        }
        Collections.reverse(res);
        return res;
    }

    // 当前运算符不是括号时，将当前运算符与栈顶的运算符比较，
    // 如果大于栈顶运算符，则直接入栈
    // 否则将栈顶运算符出栈，直到遇到优先级低的操作符或栈为空，出栈的存入 vals
    public void operationOpStack(char op, int curPriority) {
        while (!ops.isEmpty()) {
            char top = ops.pop();
            if (top == '(') {
                ops.push(top);
                break;
            }
            int prePriority;
            if (top == '+' || top == '-')
                prePriority = 1;
            else
                prePriority = 2;
            if (prePriority < curPriority) {
                ops.push(top);
                break;
            } else {
                vals.push(String.valueOf(top));
            }
        }
        ops.push(op);
    }

    // 遇到 ')'，将 ops 中 '(' 前的所有运算符出栈，存到 vals 中
    public void operationParen() {
        while (!ops.isEmpty()) {
            char op = ops.pop();
            if (op == '(')
                break;
            else
                vals.push(String.valueOf(op));
        }
    }

    public static void main(String[] args) {
//        d2 d2 = new d2();
//        String s = "10+2*3+(4*5+6)*7";
//        System.out.println(d2.convert(s));
        Collection<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        list.add(11);
        list.add(12);
        get(list);
        get(list);
        get(list);
        get1(set);
    }

    static void get1(Set set) {
        System.out.println("jj");
    }

    static void get(Collection col) {
        System.out.println("hh");
    }

//    static void get(List list) {
//        System.out.println("ll");
//    }
//
//    static void get(ArrayList arr) {
//        System.out.println("kk");
//    }


}
