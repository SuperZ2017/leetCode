package Double_Pointer;

/**
 * 盛水最多的容器
 */
public class a11 {

    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int res = 0;
        int area = 0;
        while (l < r) {
            area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(area, res);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return res;
    }
}
