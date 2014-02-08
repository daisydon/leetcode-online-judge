public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[] sum = new int[triangle.get(n - 1).size()];
        if (n == 0) return 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == n - 1) {
                    sum[j] = triangle.get(i).get(j);
                }
                else {
                    sum[j] = Math.min(sum[j], sum[j+1]) + triangle.get(i).get(j);
                }
            }
        }
        return sum[0];
    }
}