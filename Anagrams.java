public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
       ArrayList<String> ret = new ArrayList<>();
       
       String[] sorted = new String[strs.length];
       Map<String, ArrayList<String>> map = new HashMap<>();
       for (int i = 0; i < strs.length; i++) {
           sorted[i] = sort(strs[i]);
           if(map.get(sorted[i]) != null) {
              ArrayList<String> tmp = map.get(sorted[i]);
              tmp.add(strs[i]);
              map.put(sorted[i], tmp);
           }
           else {
               ArrayList<String> tmp = new ArrayList<>();
               tmp.add(strs[i]);
               map.put(sorted[i], tmp);
           }
       }
       
       for(String s: map.keySet()) {
           if(map.get(s).size() > 1) {
             ret.addAll(map.get(s));
           }
       }
        return ret;
    }
    
    private String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}