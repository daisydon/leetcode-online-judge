public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] num = new int[n + 1];
        int fact = 1;
        for (int i = 1; i < n + 1; i++) {
            num[i] = i;
            fact *= i;
        }
        fact = fact / n;
        for (int j = 1; j <= n; j++) {
            int digit = 0;
            if (k % fact != 0) {
                digit = k / fact + 1;
                k = k % fact;
            }
            else {
                digit = k / fact;
                k = fact;
            }
            
            if (n != j)  fact /= (n - j);
            int tmp = 0;
            for (int t = 1, counter = 0; t <= n; t++) {
                if (num[t] != -1) {
                    counter++;
                }
                if (counter == digit) {
                    tmp = num[t];
                    num[t] = -1;
                    break;
                }
            }
            sb.append(tmp);     //make a mistake here, it will take tmp as ASCII, no need use '0' + tmp
        }
        return sb.toString();
    }
}