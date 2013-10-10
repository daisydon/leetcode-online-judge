public class Solution {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (target <= A[0]) return 0;
        for(int i=0; target>A[i];i++){
            if(i == A.length-1) return i+1;
            if(target<=A[i+1]) return i+1;
        }
        return 0;
    }
}