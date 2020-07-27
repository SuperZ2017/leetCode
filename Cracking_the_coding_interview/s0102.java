package Cracking_the_coding_interview;

/**
 *  检查两个字符串的字符数是否相同
 *
 *  创建一个类似于散列表的数组（从第4行到第7行），将其每个字符映射到其字符出现的次数。
 *  增加第一个字符串，然后减少第二个字符串，如果两者互为重排，则该数组最终将为0。
 */
public class s0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] letters = new int[128]; // 假设为ASCII字符
        for (int i = 0; i < s2.length(); i++)
            letters[s1.charAt(i)]++;

        for (int j = 0; j < s2.length(); j++) {
            letters[s2.charAt(j)]--;
            if (letters[s2.charAt(j)] < 0)
                return false;
        }

        return true; // 字母没有负值，因此也没有正值
    }
}
