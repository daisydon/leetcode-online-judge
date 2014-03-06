public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < num.length - 3; i++) {
            while (i > 0 && i < num.length- 3 && num[i] == num[i - 1]) i++;
            
            for(int j = i + 1; j < num.length - 2; j++) {
                while (j > i + 1 && j < num.length - 2 && num[j] == num[j - 1]) j++;
                int s = j + 1, e = num.length - 1;
                
                while (s < e) {
                    int sum = num[i] + num[j] + num[s] + num[e];
                    if (sum == target) {
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[s]);
                        list.add(num[e]);
                        ret.add(new ArrayList<Integer>(list));
                        list = new ArrayList<Integer>();
                        s++;
                        e--;
                        while (s < e && num[s] == num[s - 1]) s++;
                        while (s < e && num[e] == num[e + 1]) e--;
                    }
                    else if (sum < target) {
                        s++;
                        while (s < e && num[s] == num[s - 1]) s++;
                    }
                    else {
                        e--;
                        while (s < e && num[e] == num[e + 1]) e--;
                    }
                }
            }
        }
        return ret;
    }
}