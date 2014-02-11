	public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int i = 0;
        int j = 0;
        int acc = 0;
        while (true) {
          if (j >= N) return i;
          
          if (i + j >= N) {
            acc += gas[i + j - N] - cost[i + j - N];
          }
          else {
            acc += gas[i + j] - cost[i + j];
          }
          
          if (acc < 0) {
              j++;
              i += j;        //key point 
              
              if (i >= N) return -1;
              acc = 0;
              j = 0;
          }
          else {
              j++;
          }
        }
    }
}