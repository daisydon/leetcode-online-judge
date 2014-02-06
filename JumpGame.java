public class Solution {
    public boolean canJump(int[] A) {
        int range = 0;     //use to store the jumping range [current, range]
        for(int i = 0; i < A.length && i <= range; i++) {
            if (A[i] + i > range) {
                range = A[i] + i;
            }
            if (A[i] + i >= A.length - 1) {
                return true;
            }
        } 
        return false;
   