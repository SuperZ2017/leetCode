package Cracking_the_coding_interview;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 数组下标为｛0,3,6,9....,0+3*(stackSize-1)}存放stack0;
 * 数组下标为｛1,4,7,10....,1+3*(stackSize-1)}存放stack0;
 * 数组下标为｛2,5,8,11....,2+3*(stackSize-1)}存放stack0;
 */
public class s0301 {

    int[] arr;
    int[] stackTop; // 标记每个栈的栈顶可插入元素的下标（在arr中的下标）
    int stackSize;
    public s0301(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize * 3];
        stackTop = new int[]{0, 1, 2};
    }

    // stackNum表示栈下标，value表示压入的值
    public void push(int stackNum, int value) {
        int curStackTop = stackTop[stackNum]; // 得到当前下标对应的栈的栈顶下标
        if (curStackTop / 3 == stackSize)  // 当前下标是3的倍数，则栈满
            // 栈已满
            return;

        arr[curStackTop] = value;
        stackTop[stackNum] += 3;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }

        int value = arr[stackTop[stackNum] - 3]; //删除对应的栈顶元素,前面加入元素的时候加了3，现在要减掉
        stackTop[stackNum] -= 3; // 栈顶下标减3
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum))
            return -1;

        return arr[stackTop[stackNum] - 3];
    }

    public boolean isEmpty(int stackNum) {
        return stackTop[stackNum] < 3; //栈顶下标小于3，说明没有元素了
    }

}
