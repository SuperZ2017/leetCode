package week4;

public class a556 {

    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i])
            i--;
        if (i < 0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[i] <= a[j])
            j--;
        swap(a,i,j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(char[] a, int i) { //  反转
        int start = i, end = a.length - 1;
        while (start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] a = {'1','2','3'};
        String b = a.toString();
        String c = new String(a);
        int d = Integer.parseInt(c);
        int f = Integer.valueOf(c);
        System.out.println(f);
        System.out.println(d);
    }
}
