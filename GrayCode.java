public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( n == 0) {
            result.add(0);
            return result;
        }
        
        ArrayList<String> acc = generator(n);
        for(int i = 0; i < acc.size(); i++) {
            int sum = 0;
            for(int j = 0; j < acc.get(i).length(); j++) {
                int d = acc.get(i).charAt(j) - '0';
                sum = sum * 2 + d;
            }
            result.add(sum); 
        }
        return result;
    }
    
    private ArrayList<String> generator(int n) {
        ArrayList<String> acc = new ArrayList<String>();
        if (n == 1) {
            
            acc.add("0");
            acc.add("1");
            return acc;
        }
        else {
            ArrayList<String> pre = generator(n - 1);
            ArrayList<String> reversed = reverse(pre);
            
            for(int i = 0; i < pre.size(); i++) {
                StringBuilder sb = new StringBuilder();
                acc.add(sb.append("0").append(pre.get(i)).toString());  
            }
            for(int j = 0; j < reversed.size(); j++) {
                StringBuilder sb = new StringBuilder();
                acc.add(sb.append("1").append(reversed.get(j)).toString());
            }
            
            return acc;
        }
    }
    
    private ArrayList<String> reverse(ArrayList<String> list) {
        ArrayList<String> acc = new ArrayList<String>();
        for (int i = list.size() - 1; i >= 0; i--) {
            acc.add(list.get(i));
        }
        return acc;
    }
}