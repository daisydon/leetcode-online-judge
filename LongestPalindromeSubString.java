public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return null;
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder(s.substring(0,1));
        for (int i = 0; i < n; i++) {
            String tmp = spander(s, i, i);
            if (tmp.length() > sb.length()) {
                sb = new StringBuilder(tmp);
            }
            tmp = spander(s, i, i + 1);
            if (tmp.length() > sb.length()) {
                sb = new StringBuilder(tmp);
            }
        }
        return sb.toString();
    }
    
    private String spander(String s, int start, int end) {
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            
        }
        return s.substring(start + 1, end);
    }
    
}