public class Solution {
    public ArrayList<ArrayList<String>> set = new ArrayList<>();
    
    public ArrayList<ArrayList<String>> partition(String s) {
     ArrayList<String> list = new ArrayList<>();
     find(0, s, list);
     return set;
    }
    
    private void find(int start, String s, ArrayList<String> list) {
        if (start >= s.length()) {
            set.add(new ArrayList<String> (list));
        }
        for (int i = start; i < s.length(); i++) {
            
            if (isPalindrome(start, i, s)) {
                ArrayList<String> tmp = new ArrayList<>(list);
                tmp.add(s.substring(start, i + 1));
                find(i + 1, s, tmp);
            }
        }
    }
    
    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
         if (s.charAt(start) == s.charAt(end)) {
             start++;
             end--;
         }
         else {
             return false;
         }
        }
        return true;
    }
}