public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer> buffer = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++) {
            buffer.add(0);
        }
        ArrayList<ArrayList<Integer>> collection = new ArrayList<>();
        
        combineHelper(n, k, collection, buffer);
        return collection;
    }
    
    private void combineHelper(int n, int k, ArrayList<ArrayList<Integer>> collection, ArrayList<Integer> acc) {
        if (k == 0) {
            collection.add(new ArrayList<Integer>(acc));
        } else if (n > k) {
            for (int i = n; i >= k; i--) {
                acc.set(k - 1, i);
                combineHelper(i - 1, k - 1, collection, acc);
            }
        } else {
            for (int i = k; i >= 1; i--) {
                acc.set(i - 1, i);
            }
            collection.add(new ArrayList<Integer>(acc));
        }
        
    }
}