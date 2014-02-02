package arraylist;

public class AddBinary {
	private static String reverseString(String a) {
        if (a.length() == 0)  return null;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        String l1 = reverseString(a);
        String l2 = reverseString(b);
        
        for (int i = 0; i < Math.min(l1.length(), l2.length()); i++) {
            int d1 = l1.charAt(i) - '0';
            int d2 = l2.charAt(i) - '0';
            
            if (d1 == 1 && d2 == 1) {
                if (add == 0) {
                   sb.append('0'); 
                }
                else {
                   sb.append('1');
                }
                add = 1;
            }
            else if (d1 == 0 && d2 == 0) {
               if (add == 0) {
                   sb.append('0');
               }
               else {
                   sb.append('1');
               }
               add = 0;
            }
            else {
                if (add == 0) {
                    sb.append('1');
                    add = 0;
                }
                else {
                    sb.append('0');
                    add = 1;
                }
            }
        }
        
        System.out.println(sb);
        System.out.println(l2.length());
        
       if (l1.length() > l2.length()) {
           for (int j = l2.length(); j < l1.length(); j++) {
             if (l1.charAt(j) == '1' && add == 1) {
            	 sb.append('0');
            	 add = 1;
             }
             else if (l1.charAt(j) == '0' && add == 0){
            	 sb.append('0');
            	 add = 0;
             }
             else {
            	 sb.append('1');
            	 add = 0;
             }
           }
       }
       
       System.out.println(sb);

       if (l1.length() < l2.length()) {
           for (int j = l1.length(); j < l2.length(); j++) {
        	   if (l2.charAt(j) == '1' && add == 1) {
              	 sb.append('0');
              	 add = 1;
               }
               else if (l2.charAt(j) == '0' && add == 0){
              	 sb.append('0');
              	 add = 0;
               }
               else {
              	 sb.append('1');
              	 add = 0;
               }   
           }
       }
       
       if (add == 1) {
           sb.append('1');
       }
       return reverseString(sb.toString()); 
    }

}
