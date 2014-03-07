public class Solution {
    public int numDistinct(String S, String T) {
        int[][] map = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            map[i][0] = 1;
        }
        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < T.length() + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j] + map[i - 1][j - 1];
                }
                else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        return map[S.length()][T.length()];
    }
}