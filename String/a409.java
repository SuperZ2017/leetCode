package String;


// 在对char数组遍历的时候 只能出现一个个数为奇数的字符
// 所以我们直接记录有多少个字符出现次数为奇数就可以了啊 不用额外判断了

/**
 * 最长回文串
 */
public class a409 {

    public  static int longestPalindrome(String s) {

        char[] ch = s.toCharArray();
        int[] arr = new int[128];
        int count = 0;
        for (char c : s.toCharArray())
            arr[c]++;

        // 记录有多少个字符出现次数为奇数
        for (int i : arr)
            count += i % 2;

        return count == 0 ? s.length() : s.length() - count + 1;
    }

    public static void main(String[] args) {
        String a = "aaabbccdsf";
        System.out.println(longestPalindrome(a));
    }
}