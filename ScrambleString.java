public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        
        return isTrue(s1, s2);
    }
    
    private boolean isTrue(String s1, String s2) {
        if (s1.equals(s2)) return true;
        
        int[] ar1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ar1[s1.charAt(i) - 'a'] += 1;
            ar1[s2.charAt(i) - 'a'] -= 1;
        }
        
        for (int i = 0; i < ar1.length; i++) {
            if (ar1[i] != 0) return false;
        }
        
    for (int j = 1; j < s1.length(); j++) {
        String s11 = s1.substring(0, j);
        String s12 = s1.substring(j);
        
        if (isTrue(s11, s2.substring(0,j)) && isTrue(s12, s2.substring(j))) {
            return true;
        }
        if (isTrue(s11, s2.substring(s1.length() - j)) && isTrue(s12, s2.substring(0, s1.length() - j))) {
            return true;
        }
    }
       return false;
    }
}