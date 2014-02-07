public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num); //sort the array
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());  //base case: add the []
        int ex = 0;
        
        ArrayList<ArrayList<Integer>> before = new ArrayList<>();  //to store new added arraylist of previous index
        //put num[0] into before and list, then iterate from index 1
        if (num.length > 0) {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            ex = num[0];
            pre.add(num[0]);
            list.add(pre);
            before.add(pre);
        }
        
        for (int i = 1; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            
            if (num[i] == ex) {
               for (ArrayList<Integer> e: before) {
                 ArrayList<Integer> tmp = new ArrayList<Integer>(e); 
                 tmp.add(num[i]);
                 current.add(tmp);
               }
               
            }
            else {
                for (ArrayList<Integer> e: list) {
                   ArrayList<Integer> tmp = new ArrayList<>(e);
                   tmp.add(num[i]);
                   current.add(tmp);
                }
            }
            //put all the new subsets into before
            before = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> e: current) {
                before.add(new ArrayList<Integer>(e));
            }
            list.addAll(current);
            ex = num[i];
        }
        
        return list;
    }
    
}