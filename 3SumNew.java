public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1] && i < num.length - 2) continue;
            int s = i + 1, e = num.length - 1;
            while (s < e) {
                int sum = num[i] + num[s] + num[e];
                if (sum == 0) {
                    list.add(num[i]);
                    list.add(num[s]);
                    list.add(num[e]);
                    ret.add(new ArrayList<Integer>(list));
                    list = new ArrayList<Integer>();
                    s++;
                    e--;
                    while (s < e && num[s] == num[s - 1]) s++;
                    while (s < e && num[e] == num[e + 1]) e--;
                }
                else if (sum < 0) {
                    s++;
                    while (s < e && num[s] == num[s - 1]) s++;
                }
                else {
                    e--;
                    while (s < e && num[e] == num[e + 1]) e--;
                }
            }
        }
        return ret;
    }
}