public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 0) return prefix.toString();
        
        prefix.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            String pre = prefix.toString();
            prefix = new StringBuilder(findPrefix(cur, pre));
        }
        
        return prefix.toString();
    }
    
    private String findPrefix (String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }
}