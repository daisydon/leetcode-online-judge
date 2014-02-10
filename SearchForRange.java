public class Solution {
    public int[] searchRange(int[] A, int target) {
        
        return binarysearch(0, A.length - 1, A, target);
    }
    
    private int[] binarysearch(int start, int end, int[] A, int target) {
        int[] re = {-1, -1};
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (start == end && A[mid] != target) {
                break;
            }
            
            if (A[mid] > target) {
                end = mid;
            }
            else if (A[mid] < target) {
                start = mid + 1;
            }
            else {
                int i = mid;
                int j = mid;
                while (i >= start && A[i] == target) {
                   
                    re[0] = i;
                    i--;
                }
                while (j <= end && A[j] == target) {
                   
                    re[1] = j;
                    j++;
                }
                break;
            }
        }
        return re;
    }
}