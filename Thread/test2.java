package Thread;

/**
 * 两个线程交替打印数组
 */
public class test2 {

    int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
    private Object lock = new Object();
    int flag = 1;

    void startThreadA() {
        new Thread(() -> {
            for (int i = 0; i < 8; i += 2) {
                synchronized (lock) {
                    while (flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 0;
                    System.out.println(a[i]);
                    lock.notifyAll();
                }
            }
        }).start();
    }

    void startThreadB() {
        new Thread(() -> {
            for (int i = 1; i < 8; i += 2) {
                synchronized (lock) {
                    while (flag != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(a[i]);
                    flag = 1;
                    lock.notifyAll();
                    }
                }
        }).start();
    }

    public static void main(String[] args) {
        test2 test2 = new test2();
        System.out.println(1 != 1);
//        test2.startThreadA();
//        test2.startThreadB();
    }
}
