package List;

public class test {

    public static void main(String[] args) {
        one l1 = new one("11", 1);
        one l2 = new one("12", 2);
        l2 = l1;
        System.out.println(l2);
        l1.setAge(19);
        l1.setName("wx");
        System.out.println(l2);
        l2.setName("qq");
        System.out.println(l1);
    }
}
