package Matrix;

/**
 * 除自身以外数组的乘积
 *
 * 不使用除法，在 O(n)的时间复杂度完成
 *
 * 乘积 = 当前数左边的乘积 * 当前数右边的乘积
 */
public class a238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = k;
            k = k * nums[i];    // 此数组存储的是除去当前元素左边的元素乘积
        }

        k = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= k;    // k为该数右边的乘积
            k *= nums[i];   // 此时数组等于左边的 * 该数右边的
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        for (int n : nums)
            System.out.println(n);
    }
}
