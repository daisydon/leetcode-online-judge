public class Solution {
    
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3 || num.length == 0)  return 0;
        
        int[] sorted = new int[num.length];
        sorted = Sort(num, 0, num.length - 1);
        
        int abs = Integer.MAX_VALUE;
        int record = 0;
        
        for (int i = 0; i < sorted.length; i++) {
            int start = i + 1;
            int end = sorted.length - 1;
            
            while (start < end) {
                int sum = sorted[i] + sorted[start] + sorted[end];
                if (sum == target) {
                    abs = 0;
                    record = target; 
                    break;
                }
                else if (sum > target) {
                    if (Math.abs(sum - target) < abs) {
                        abs = Math.abs(sum - target);
                        record = sum;
                    }
                    end--;
                }
                else if (sum < target) {
                    if (Math.abs(sum - target) < abs) {
                        abs = Math.abs(sum - target);
                        record = sum;
                    }
                    start++;
                }
              }
              //TODO: if the same numer, jump to next              
              while (i < sorted.length - 1 && sorted[i] == sorted[i+1] )  i++;
         }
         return record;
    }
    
    private int[] Sort(int[] num, int start, int end) {
        
        if (start < end) {
            int mid = (start + end) /2;
            return Merge(Sort(num, start, mid), Sort(num, mid + 1, end));
        }
        else {
            int[] temp = new int[1];
            temp[0] = num[start];
            
            return temp; 
        }
    }
    
    private int[] Merge (int[] part1, int[] part2) {
        int l1 = part1.length;
        int l2 = part2.length;
        
        int[] temp = new int[l1 + l2];
        
        for (int i = 0, m = 0, n = 0; i < l1 + l2; i++) {
            if (m < l1 && n < l2) {
             if(part1[m] > part2[n]) {
                temp[i] = part2[n];
                n++;
             }
             else {
                temp[i] = part1[m];
                m++;
             }
           }
           else if (m == l1) {
              temp[i] = part2[n];
              n++;
           }
           else if (n == l2) {
               temp[i] = part1[m];
               m++;
           }
        }
        return temp;
    }
    
    
  }
