package Thread;

/**
 * 死锁
 */
public class DeadLockDemo {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    private static void startThreadA() {
        new Thread(() -> {
            synchronized (lockA) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                synchronized (lockB) {

                }
            }
        }).start();
    }

    private static void startThreadB() {
        new Thread(() -> {
            synchronized (lockB) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                synchronized (lockA) {

                }
            }
        }).start();
    }

    public static void main(String[] args) {
        startThreadA();
        startThreadB();
    }

}
