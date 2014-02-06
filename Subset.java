public class Solution {
    
        
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        Arrays.sort(S);
        
        for (int i = 0; i < S.length; i++) {
        ArrayList<ArrayList<Integer>> cur = new ArrayList<>();
        
            for(ArrayList<Integer> pre: list) {
                cur.add(new ArrayList<Integer>(pre));
            }
            
            for(ArrayList<Integer> update: cur) {
                update.add(S[i]);
            }
        list.addAll(cur);
            
        }
       
        return list;
    }

}