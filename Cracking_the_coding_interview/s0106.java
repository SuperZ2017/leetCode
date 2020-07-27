package Cracking_the_coding_interview;

/**
 * 压缩字符串
 */
public class s0106 {

    public String compressString(String S) {
        StringBuilder comparessed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < S.length(); i++) {
            countConsecutive++;

            /* 如果下一个字符与当前字符不同，那么将当前字符添加到结果尾部 */
            if (i + 1 >= S.length() || S.charAt(i) != S.charAt(i + 1)) {
                comparessed.append(S.charAt(i));
                comparessed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return comparessed.length() < S.length() ? comparessed.toString() : S;
    }
}
