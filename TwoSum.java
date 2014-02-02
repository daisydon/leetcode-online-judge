public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            new IllegalArgumentException("Array is empty!");
        }
        int[] sorted = Sort(numbers, 0, numbers.length - 1);
        int[] index = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            int s = i + 1;
            int e = numbers.length - 1;
            
            if (s == e) {
                if (sorted[i] + sorted[s] == target) {
                    index[0] = i;
                    index[1] = s;
                    break;  
                }
            }
            
            while (s < e) {
                int m = (s + e)/2;
                if (sorted[i] + sorted[m] == target) {
                    index[0] = i;
                    index[1] = s;
                    break;
                }
                else if (sorted[i] + sorted[m] > target) {
                    e = m;
                }
                else {
                    s = m + 1;
                }
            }
            while (i < numbers.length - 1 && sorted[i] == sorted[i+1]) {
                i++;
            }
          }
          return index;
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
    
    private class Node {
        public int val;
        public int old;
        public int cur;
        
        public Node () {
            
        }
        public Node val(int val) {
            this.val;
            return this;
        }
        public Node old(int old) {
            this.val;
            return this;
        }
        public Node cur(int cur) {
            this.cur = cur;
            return this;
        }
    }
    
}