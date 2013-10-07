public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
      
        int s = A[0];
        int i = 1;
        while(i < A.length){
            s = s ^ A[i];
            i++;
        }
        return s;
    }
}