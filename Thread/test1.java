package Thread;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 有两个线程分别读取数组 a 和数组 b，线程 1 循环打印数组 a 中的数字，线程 2 循环打印数组 b 中的数
 */
public class test1 {

    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    int[] a = {1, 2, 3, 4, 5};
    char[] b = {'a', 'b', 'c', 'd', 'e'};

    void startThreadA() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(a[i]);
                s2.release();
            }
        }).start();
    }

    void startThreadB() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(b[i]);
                s1.release();
            }
        }).start();
    }

    public static void main(String[] args) {
        test1 test1 = new test1();
        test1.startThreadA();
        test1.startThreadB();
    }
}
