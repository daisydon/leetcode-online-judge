public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> acc = new ArrayList<>();
        if (matrix.length == 0) return acc;
        helper(matrix, matrix.length, matrix[0].length, 0, acc);

        return acc;
    }
    private void helper(int[][] matrix, int m, int n, int k, ArrayList<Integer> acc) {
        if (m <= 0 || n <=0) return;
        
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                acc.add(matrix[k][i + k]);
            }
        }
        
        else if (n == 1) {
            for (int j = 0; j < m; j++) {
                acc.add(matrix[j + k][k]);
            }
        }
        else {
            //top line 
        for (int t = 0; t < n - 1; t++) {
            acc.add(matrix[k][t + k]);
        }   
            //right line
        for (int r = 0; r < m - 1; r++) {
            acc.add(matrix[r + k][k + n - 1]);
        }
             //bottom line
        for (int b = 0; b < n - 1; b++) {
            acc.add(matrix[k + m - 1][k + n - 1 - b]);
        }
            //left line
        for (int l = 0; l < m - 1; l++) {
            acc.add(matrix[k + m - 1 - l][k]);
        }
       
        
        helper(matrix, m - 2, n - 2, k + 1, acc); 
        
     } 
    }
}