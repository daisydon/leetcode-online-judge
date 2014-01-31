public class Solution {
    public int maxArea(int[] height) {
       int start = 0;
       int end = height.length - 1;
       
       int sum = 0;
       
       while(start < end) {
           int container = (end - start) * Math.min(height[start],height[end]);
           
           if (container > sum) {
               sum = container;
           }
           
           if (height[end] < height[start]) {
               end--;
           }
           else {
               start ++;
           }
       }
       return sum;
    }
}