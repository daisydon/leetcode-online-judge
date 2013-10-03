public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> row = new ArrayList<Integer>();
        
        if(rowIndex==0) {
            row.add(1); return row;
            }
            
        for(int i=1;i<=rowIndex;i++){
            ArrayList<Integer> new_row = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                int n;
                if(j==0||j==i) { n=1;}
                else { n=row.get(j-1)+row.get(j);}
                new_row.add(n);
            }
             row = new_row;
        }
        return row;
    }
}