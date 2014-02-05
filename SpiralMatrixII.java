public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        result = generator(result, n, 0, 1);
        
        return result;
    }
    private int[][] generator(int[][] matrix, int n, int k, int num) {
        if (n <= 0) return matrix;
        
        if (n == 1) {
            matrix[k][k] = num;
            return matrix;
        }
        else {
            //top line
            for (int i = 0; i < n - 1; i++) {
                matrix[k][k+i] = num;
                num++;
            }
            
            //right line
            
            for (int j = 0; j < n - 1; j++) {
                matrix[k+j][k+n-1] = num;
                num++;
            }
            
            //bottom line
            
            for (int p = 0; p < n - 1; p++) {
                matrix[k+n-1][k+n-1-p] = num;
                num++;
            }
            
            //left line
            for (int q = 0; q < n - 1; q++) {
                matrix[k+n-1-q][k] = num;
                num++;
            }
            return generator(matrix, n - 2, k + 1, num);
        }
    }
}