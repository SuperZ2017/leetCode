package jianzhioffer;

/**
 * 表示数值的字符串
 */
public class b20 {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return true;
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                // . 之前不能出现 . 或者 e
                if (dotSeen || eSeen)
                    return false;
                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                // e 之前不能出现 e，必须出现数
                if (eSeen || !numSeen)
                    return false;
                eSeen = true;
                numSeen = false; // 重置 numSeen，排除 123e 或者 123e+ 的情况，确保e之后也出现数
            } else if (str[i] == '-' || str[i] == '+') {
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if (i != 0 && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
            } else {
                // 其他不合法字符
                return false;
            }
        }

        return numSeen;
    }
}
