package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a14 {

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0)
            return "";

        String prefx = strs[0];

        for(int i=1; i<strs.length; i++){
             while (strs[i].indexOf(prefx) != 0){  // 为0意味着str中能完全找到prefx
                prefx = prefx.substring(0, prefx.length() - 1);
                if(prefx.isEmpty())
                    return "";
            }
        }

        return prefx;
    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        System.out.println(isPalindrome(121));
        Integer a = null;
        String b = null;
        System.out.println(b + 1);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int y = x;
        int p = 0;
        while (x != 0) {
            p = p * 10 + x % 10;
            x /= 10;
        }

        return p == y;
    }

}
