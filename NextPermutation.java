public class Solution {
    public void nextPermutation(int[] num) {
        //classic math problem
        // find the first number from right to left which breaks the increasing trend
        int bnum = 0;
        int index = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                bnum = num[i];
                index = i;
                break;
            }
        }
        //if it keeps increasing, then just reverse the array
        if (index == -1) {
            reverse(0, num.length - 1, num);
        }
        //find the first number which is larger than the first break number
        else {
            
            for (int i = num.length - 1; i > index; i--) {
                if (num[i] > bnum) {
                    num[index] = num[i];
                    num[i] = bnum;
                    break;
                }
            }
            reverse(index + 1, num.length - 1, num);
        }
        
    }
    
    private void reverse(int start, int end, int[] num) {
        if (start < end) {
            
            for (int i = start, j = end; i < j; i++, j--) {
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
            }
        }
        
    }
}