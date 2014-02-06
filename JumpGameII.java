public class Solution {
    public int jump(int[] A) {
        int n = A.length;
        int[] step = new int[n];
        int range = 0;
        
        for (int i = 0; i <= range && i < n; i++) {
            if (A[i] + i > range) {
                range = i + A[i];
                for (int j = i; j <= range && j < n; j++) {
                    if (step[j] == 0 && j != 0) {      //step[0] = 0
                        step[j] = step[i] + 1;
                    }
                    else step[j] = Math.min(step[j], step[i] + 1);
                }
            }
        }
        return step[n - 1];
    }
}