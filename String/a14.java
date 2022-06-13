package String;

/**
 * 最长公共前缀
 */
public class a14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {  // 为 0 意味着 str 中能完全找到 prefix
                prefix = prefix.substring(0, prefix.length() - 1); // 去掉末尾最后一个数字
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String s = "   ";
        System.out.println(s.isEmpty());
        System.out.println(s.length());
    }
}
