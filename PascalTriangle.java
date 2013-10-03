public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> collection=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();               
        if (numRows ==0) {return collection;}
        
        for(int i=1;i<=numRows;i++){
            ArrayList<Integer> new_row = new ArrayList<Integer>();     
            int n;
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                   n=1;
                }
                else
                {
                    n=row.get(j-2)+row.get(j-1);
                }
                new_row.add(new Integer(n));
            }
            row=new_row;
            collection.add(row);
        }
        return collection;
    }
}