public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] s= new int[n+1];
        s[0]=1;
        s[1]=1;
        
        
        for(int i=2;i<=n;i++){
         for(int j=1;j<=i;j++){
          s[i]+=s[j-1]*s[i-j]; }
        }
        return s[n];}
}
