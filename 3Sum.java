public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        if (num.length < 3 || num.length == 0) {
            return set;
        }
        else {
            int[] sorted = new int[num.length];
            sorted = Sort(num, 0, num.length - 1);
            
            ArrayList<Integer> acc = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                acc.add(0);
            }
            
            for (int i = 0; i < sorted.length - 2; i++) {
                int s = i + 1;
                int e = sorted.length - 1;
                
                while (s < e) {
                    if (sorted[i] + sorted[s] + sorted[e] == 0) {
                        acc.set(0, sorted[i]);
                        acc.set(1, sorted[s]);
                        acc.set(2, sorted[e]);
                        set.add(new ArrayList<Integer>(acc));
                        while (s < e - 1 && sorted[s] == sorted[s + 1]) {
                            s++;
                        }
                        while (s < e - 1 && sorted[e] == sorted[e - 1]) {
                            e--;
                        }
                        s++;
                    } 
                    else if (sorted[i] + sorted[s] + sorted[e] > 0){
                        while (s < e - 1 && sorted[e] == sorted[e - 1]) {
                            e--;
                        }
                        e--;
                    }
                    else {
                        while (s < e -1 && sorted[s] == sorted[s + 1]) {
                            s++;
                        }
                        s++;
                    }
                }
                while (i < sorted.length - 1 && sorted[i] == sorted[i + 1]) {
                    i++;
                }
            }
        }
        return set;
        
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