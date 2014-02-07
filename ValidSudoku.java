public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //check all the column and row
        for (int r = 0; r < board.length; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> col = new ArrayList<>();
            for(int i = 0; i < board[0].length + 1; i++) {
                    col.add(0);
                    row.add(0);
            }
            
            
            for(int c = 0; c < board[0].length; c++) {
                
                if (board[r][c] != '.') {
                 int num = board[r][c] - '0';
                 row.set(num, row.get(num) + 1);
                 if (row.get(num) > 1) return false;
                }
                
                if (board[c][r] != '.') {
                 int num = board[c][r] - '0';
                 col.set(num, col.get(num) + 1);
                 if (col.get(num) > 1) return false;
                }
            }
         }
         
        // check all the nine subsets
       for (int r = 0; r < 9; r = r + 3) {
           for (int c = 0; c < 9; c = c + 3) {
                ArrayList<Integer> list = new ArrayList<>();
                for(int t = 0; t < 10; t++)  list.add(0);
                
                for(int i = r; i < r + 3; i++) {
                   for(int j = c; j < c + 3; j++) {
                       if (board[i][j] != '.') {
                           int n = board[i][j] - '0';
                           list.set(n, list.get(n) + 1);
                           if(list.get(n) > 1)  return false;
                       }
                   }
               }
           }
       }
        
       return true; 
    }
}