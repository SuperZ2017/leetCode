package Double_Pointer;

/**
 * 移动零，easy
 */
public class a283 {

    public void moveZeroes(int[] nums) {
        int indx_Now = 0;
        int indx_Num = 0;
        int m = nums.length;

        while (indx_Num < m) {
            if (nums[indx_Num] != 0) {
                nums[indx_Now++] = nums[indx_Num];
            }
            indx_Num++;
        }

        for (int i = indx_Now; i < m; i++) {
            nums[i] = 0;
        }
    }
}
