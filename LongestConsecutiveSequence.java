public class Solution {
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = Integer.MIN_VALUE;
        int[] visited = new int[num.length];
        
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
            
        }
        
        for (int i = 0; i < num.length; i++) {
            if (visited[i] != 1) {
              visited[i] = 1;                 //base case: at least 1 consecutive 
              int before = num[i] - 1;
              int after = num[i] + 1;
              int sum = 1;
              while (map.containsKey(before)) {
                  visited[map.get(before)] = 1;
                  sum++;
                  before--;
              } 
              while (map.containsKey(after) ) {
                  visited[map.get(after)] = 1;
                  sum++;
                  after++;
              }
              counter = Math.max(counter, sum);
            }
        }
        return counter;
    }
}