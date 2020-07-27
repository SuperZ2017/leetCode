package Cracking_the_coding_interview;

public class s0105 {

    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1)
            return false;

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // 确保此处为发现的第一处不同
                if (foundDifference)
                    return false;
                foundDifference = true;

                if (s1.length() == s2.length())     // 更换后，移动较短字符串的指针（当长度相同时，替换后先移动s1）
                    index1++;
            } else {
                index1++; // 如果相匹配，就移动较短字符串的指针
            }
            index2++; // 总是移动较长字符串的指针

        }
        return true;
    }
}
