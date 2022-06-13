package Double_Pointer;

/**
 * 两数之和
 */
public class a167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int idx1 = 0, idx2 = numbers.length - 1;
        while (idx1 < idx2) {
            if (numbers[idx1] + numbers[idx2] == target) {
                ans[0] = idx1 + 1;
                ans[1] = idx2 + 1;
                return ans;
            } else {
                if (numbers[idx1] + numbers[idx2] < target) {
                    idx1++;
                } else {
                    idx2--;
                }
            }
        }
        return ans;
    }
}
