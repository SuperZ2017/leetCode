package Game;

public class d5405 {

    public static int countTriplets(int[] arr) {

        int a = 0, b = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    for (int m = i; m <= j-1; m++)
                        a ^= arr[m];
                    for (int n = j; n <= k; n++)
                        b ^= arr[n];
                    if (a == b)
                        count++;
                    a = 0;
                    b = 0;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {7,11,12,9,5,2,7,17,22};
        System.out.println(countTriplets(arr));
    }
}
