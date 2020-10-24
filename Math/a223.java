package Math;

/**
 * 矩形面经
 */
public class a223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = 0, b = 0, c = 0;
        a = (C - A) * (D - B);
        c = (G - E) * (H - F);
        // 左下交点
        int x1 = Math.max(A, E), y1 = Math.max(B, F);
        //右上交点
        int x2 = Math.min(C, G), y2 = Math.min(D, H);
        if (y2 >= y1 && x2 >= x1) {
            b = (y2 - y1) * (x2 - x1);
        }

        return a - b + c;
    }

}
