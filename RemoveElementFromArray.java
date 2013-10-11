public class Solution {
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = A.length;
        for(int i=0; i<len; ){
            if(A[i] == elem) A[i]=A[--len];
            else i++;
        }
        
        return len;
    }
}