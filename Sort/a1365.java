package Sort;

/**
 * 有多少小于当前数字的数字
 *
 * 计数排序
 */
public class a1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 数组元素的值域为 [0,100]，所以可以考虑建立一个频次数组 cnt ，cnt[i] 表示数字 i 出现的次数。
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(Integer.valueOf(s));
        System.out.println(Integer.parseInt(s));
    }

}
