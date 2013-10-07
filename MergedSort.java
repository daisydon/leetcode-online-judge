public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int r = m+n-1, i = m-1, j = n-1;
        for(;i>=0&&j>=0;r--){
            if(A[i]>B[j]){
                A[r] = A[i];
                i--;
            }
            else{
                A[r] = B[j];
                j--;
            }
        }                   
       for(;j>=0;j--){
           A[r] = B[j];
           r--;
       }
    }
}