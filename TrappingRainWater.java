public class Solution {
    public int trap(int[] A) {
        if (A.length == 0 || A.length == 1) return 0;
        
        int acc = 0;
        int[] l = new int[A.length];
        l[0] = 0;
        int[] r = new int[A.length];
        r[A.length - 1] = 0;
        
        for (int i = 1; i < A.length; i++) {
            l[i] = Math.max(l[i - 1], A[i - 1]);
        }
        
        for (int j = A.length - 2; j >= 0; j--) {
            r[j] = Math.max(r[j + 1], A[j + 1]);
        }
        
        for (int m = 0; m < A.length; m ++) {
            if (Math.min(r[m], l[m]) > A[m]) {
                acc += Math.min(r[m],l[m]) - A[m];
            }
        }
        return acc;
    }
}