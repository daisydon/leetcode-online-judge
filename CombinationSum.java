public class Solution {
    public ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> acc = new ArrayList<>();
        dfs (candidates, target, 0, acc);
        return list;
    }
    
    private void dfs (int[] candidates, int target, int start, ArrayList<Integer> acc) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(acc));
        }
        else if (target > 0) {
            for(int i = start; i < candidates.length;  i++) {
                if (i > 0 && candidates[i - 1] == candidates[i]) continue;
                ArrayList<Integer> cur = new ArrayList<>(acc);
                cur.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, cur);
            }
        }
        
    }
