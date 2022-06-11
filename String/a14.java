package String;

/**
 * 最长公共前缀
 */
public class a14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        String prefx = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefx) != 0) {  // 为0意味着str中能完全找到prefx
                prefx = prefx.substring(0, prefx.length() - 1); // 去掉末尾最后一个数字
                if (prefx.isEmpty())
                    return "";
            }
        }

        return prefx;
    }
}
