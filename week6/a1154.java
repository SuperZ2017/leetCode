package week6;

/**
 * 一年中的第几天
 */
public class a1154 {

    public int dayOfYear(String date) {
        // "2019-8-20"
        String[] strs = date.split("-");
        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int countDay = 0;
        int year = Integer.valueOf(strs[0]).intValue();
        int month = Integer.valueOf(strs[1]).intValue();
        int day = Integer.valueOf(strs[2]).intValue();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            months[2] = 29;

        for (int i = 0; i < month; i++)
            countDay += months[i];

        return countDay + day;
    }
}
