import java.util.Scanner;
public class Main2 {
    /**
     * 输入某年某月某日，判断这一天是这一年的第几天？
     *
     */
    public static void main(String[] args) {
        int year;
        int mouth;
        int day = 0;
        int days;
        //累计天数
        int d = 0;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            year = scanner.nextInt();
            mouth = scanner.nextInt();
            days = scanner.nextInt();

            if (mouth < 0 || mouth > 12 || days < 0 || days > 31) {
                System.out.println(1);
                return;
            }

            for (int i = 1; i < mouth; i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        day = 31;
                        break;
                    }

                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        day = 30;
                        break;
                    }

                    case 2: {
                        if ((year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0)) {
                            day = 29;
                        } else {
                            day = 28;
                        }
                    }

                    default:
                        break;

                }
                d += day;
            }

            System.out.println(d + days);
            d = 0;
        }
    }
}