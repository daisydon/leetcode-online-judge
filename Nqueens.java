public class Solution {
    public ArrayList<String[]> acc = new ArrayList<>();
    
    public ArrayList<String[]> solveNQueens(int n) {
        
        int[] Q = new int[n];
        for(int i = 0; i < n; i++) {
            Q[i] = -1;
        }
        
        placeQueens(0, n, Q);
        return acc;
    }
    
    private void printQueens(int[] Q, int n, ArrayList<String[]> list) {
        String[] S = new String[n];
        for(int i = 0; i< n; i++ ) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(Q[i] == j) {
                   sb.append('Q'); 
                }
                else {
                   sb.append('.'); 
                }
            }
          S[i] = sb.toString(); 
        }
        acc.add(S);
    } 
    
    private void placeQueens(int r, int n, int[] Q) {
        if (r == n) {
            printQueens(Q, n, acc);
        }
        else {
            for (int i = 0; i < n; i++) {
                Q[r] = i;
                if (isValid(r, Q)) {
                    placeQueens(r+1, n, Q);
                }
            }
        }
    }
    
    private boolean isValid(int r, int[] Q) {
        
        for (int i = 0; i < r; i++) {
            if (Q[i] == Q[r] || Math.abs(Q[i] - Q[r]) == r - i) {
                return false;
            }
        }
        return true;
    }
    
}