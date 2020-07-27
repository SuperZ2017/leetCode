package Cracking_the_coding_interview;

import javax.print.DocFlavor;

/**
 * 将空格替换为 %20
 */
public class s0103 {

    public String replaceSpaces(String S, int length) {
        char[] str = S.toCharArray();
        int spaceCount = 0, index, i = 0;
        for (; i < length; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        index = length + spaceCount * 2;
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str)
            sb.append(c);

        return sb.toString().trim();
    }
}
