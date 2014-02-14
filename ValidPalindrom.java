public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
        
            if (!isAlpha(s.charAt(i)) && !isNumber(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlpha(s.charAt(j)) && !isNumber(s.charAt(j))) {
                j--;
                continue;
            }
           
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            else {
                i++;
                j--;
            }
             
        }
        return true;
    }
    private boolean isNumber(char c) {
        if (c <= '9' && c >= '0') return true;
        return false;
    }
    
    private boolean isAlpha(char c) {
        if (c <= 'z' && c >= 'a') return true;
        if (c <= 'Z' && c >= 'A') return true;
        return false;
    }
}