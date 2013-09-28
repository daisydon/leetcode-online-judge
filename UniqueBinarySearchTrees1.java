public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(n==0 || n==1) {return 1;}
        else{
            int s1=0,s2=0,s=0;
            for(int i=0;i<n;i++){
            s1=numTrees(i);
            s2=numTrees(n-i-1);
            s+=s1*s2;
        }
        return s;}       
}
}
