package Greedy;

public class CpuCache {

    static int LEN = 64 * 1024 * 1024;
    static int arr[] = new int[LEN]; // 64M
    public static void main(String[] args) {
        long currAddTwo = System.currentTimeMillis();
        addTwo();
        System.out.println(System.currentTimeMillis() - currAddTwo);
        long currAddEight = System.currentTimeMillis();
        addEight();
        System.out.println(System.currentTimeMillis() - currAddEight);
    }
    private static void addTwo() {
        for (int i = 0; i < LEN; i += 2) {
            arr[i] *= i;
        }
    }
    private static void addEight() {
        for (int i = 0;i < LEN; i += 8) {
            arr[i] *= i;
        }
    }
}
