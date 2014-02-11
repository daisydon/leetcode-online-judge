public class Solution {
    public int firstMissingPositive(int[] A) {
        int re = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i],i);
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                continue;
            }
            else {
                int cur = A[i] - 1;
                
                while (cur > 0) {
                    if (!map.containsKey(cur)) {
                        re = cur;
                    }
                    cur--;
                }
                if (re == 0) {
                    cur = A[i] + 1;
                    while (map.containsKey(cur)) {
                        cur++;
                     }
                    re = cur;
                }
                
            }
        }
        
        if (re == 0) re = 1;       //if all the elements <= 0, then the value of re won't be change
        
        return re;
    }
}