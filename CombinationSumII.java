public class Solution {
    public ArrayList<ArrayList<Integer>> set = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<Integer> acc = new ArrayList<>();
        dfs(num, 0, target, acc);
        return set;
    }
    
    private void dfs(int[] num, int start, int target, ArrayList<Integer> acc) {
        if (target == 0) {
            set.add(new ArrayList<Integer>(acc));
        }
        else if (target > 0) {
            for (int i = start; i < num.length; i++) {
                 ArrayList<Integer> cur = new ArrayList<>(acc);
                 cur.add(num[i]);
                 dfs(num, i + 1, target - num[i], cur); 
                 while (i < num.length - 1 && num[i] == num[i + 1]) i++;
                 
            }
        }
        else {
            return ;
        }
    }
}