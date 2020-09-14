package Utils;

/**
 * 阿拉伯数字转中文计数
 */
public class NumberToChn {

    static String CHN_NUMBER[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    static String CHN_UNIT[] = {"", "十", "百", "千"};          //权位
    static String CHN_UNIT_SECTION[] = {"", "万", "亿", "万亿"}; //节权位

    public static String NumberToChn (int num) {
        StringBuffer res = new StringBuffer();
        boolean needZero = false;
        int pos = 0; // 节权位的位置
        if (num == 0)
            res.insert(0, CHN_NUMBER[0]);

        while (num > 0) {
            int section = num % 10000;
            if (needZero)
                res.insert(0, CHN_NUMBER[0]);

            String sectionToChn = SectionNumToChn(section);
            // 判断是否需要节权位
            sectionToChn += (section != 0) ? CHN_UNIT_SECTION[pos] : CHN_UNIT_SECTION[0];
            res.insert(0, sectionToChn);
            //判断section中的千位上是不是为零，若为零应该添加一个零。
            needZero = ((section < 1000 && section > 0) ? true : false);
            pos++;
            num /= 10000;
        }

        return res.toString();
    }

    // 将四位的 section 转换为中文数字
    public static String SectionNumToChn(int section) {
        StringBuffer res = new StringBuffer();
        int unitPos = 0;
        boolean zero = true;

        while (section > 0) {
            int v = section % 10;
            if (v == 0) {
                if ((section == 0) || !zero) {
                    zero = true; /*需要补0，zero的作用是确保对连续的多个0，只补一个中文零*/
                    res.insert(0, CHN_NUMBER[v]);
                }
            } else {
                zero = false; // 至少有一个数字不是 0
                StringBuffer tempStr = new StringBuffer(CHN_NUMBER[v]); //数字v所对应的中文数字
                tempStr.append(CHN_UNIT[unitPos]); // 数字v所对应的中文权位
                res.insert(0, tempStr);
            }
            unitPos++;
            section /= 10;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int num = 10104;
        System.out.println(NumberToChn(num));
    }
}
