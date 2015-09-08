class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        
        boolean flag = true;
        int i = 0;
        if (str.charAt(i) == '+') i++;
        else if (str.charAt(i) == '-') {
            i++;
            flag = false;
        }
        double sum = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0')  {
            if (Integer.MAX_VALUE / 10 < sum || (Integer.MAX_VALUE / 10 == sum && Integer.MAX_VALUE % 10 < Character.getNumericValue(str.charAt(i)))) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = sum * 10 + Character.getNumericValue(str.charAt(i));
            i++;
        }
        if (!flag) sum =  (-1) * sum; 
        
        return (int) sum;
    }
}
