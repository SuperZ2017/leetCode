package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 */
public class a93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (i < n && j < n && k < n) {
                        String tmp1 = s.substring(0, i + 1);
                        String tmp2 = s.substring(i + 1, j + 1);
                        String tmp3 = s.substring(j + 1, k + 1);
                        String tmp4 = s.substring(k + 1);

                        if (valid(tmp1) && valid(tmp2) && valid(tmp3) && valid(tmp4))
                            res.add(tmp1 + "." + tmp2 + "." + tmp3 + "." + tmp4);
                    }
                }
            }
        }

        return res;
    }

    private boolean valid(String tmp) {
        if (tmp == null || tmp.length() == 0 || tmp.length() > 3 ||
                (tmp.charAt(0) == '0' && tmp.length() > 1) || Integer.parseInt(tmp) > 255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String d = null;
        System.out.println(d + " 123");
    }
}
