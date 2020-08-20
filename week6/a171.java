package week6;

public class a171 {

    public static int titleToNumber(String s) {
        int num = 0;
        int j = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            num += (c - 'A' + 1) * Math.pow(26, j++);
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
//        System.out.println('Z' - 'A');
    }

}
