package data;

public class NStack {
    private int[] stack = new int[101];
    private int top;
    private int max = 0;

    public void push(int e1) {
        stack[top++] = e1 - max;
        if (e1 > max)
            max = e1;
    }

    public int pop() {
        int t = stack[top] + max;
        if (stack[top] > 0) {
            t = max;
            max -= stack[top--];
        } else {
            top--;
        }
        return t;
    }

    public int max()  {
        return max;
    }
}
