package week6;

public class d55 {

    static boolean foo(char c){
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i =0 ;
        for (foo('i');foo('j')&&(i<2);foo('k')){
            i++;
            foo('l');
        }
    }
}
