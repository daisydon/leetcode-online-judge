public class Solution {
    
    public int minCut(String s) {
        boolean isPa[][] = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if ((s.charAt(j) == s.charAt(i)) && (j - i < 2 || isPa[i+1][j-1])) {
                    isPa[i][j] = true;
                }
                else {
                    isPa[i][j] = false;
                }
            }
        }
        
        int re[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            
            if (isPa[0][i]) {
                re[i] = 0;
            }
            else {
                int pre = s.length();
                for (int j = 0; j < i; j++) {
                    if (isPa[j+1][i] && re[j] + 1 < pre) {
                        pre = re[j] + 1;
                    }
                }
                re[i] = pre;
            }
        }
        return re[s.length() - 1];
    }
}