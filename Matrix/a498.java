package Matrix;


/**
 * 矩阵对角线遍历
 */
public class a498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[]{};
        int r = 0,c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        for(int i = 0;i < res.length; i++){
            res[i] = matrix[r][c];
            if((r + c) % 2 == 0){
                if(c == col - 1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r == row - 1){
                    c++;
                }else if(c == 0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
