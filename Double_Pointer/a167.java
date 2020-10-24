package Double_Pointer;

/**
 * 两数之和
 */
public class a167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int index1 = 0, index2=numbers.length-1;
        while(index1 < index2){
            if(numbers[index1]+numbers[index2]==target){
                ans[0]=index1+1;
                ans[1]=index2+1;
                return ans;
            }else{
                if(numbers[index1]+numbers[index2]<target){
                    index1++;
                }else{
                    index2--;
                }
            }
        }
        return ans;
    }
}
