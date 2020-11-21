public class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            //i从0开始，i - map.get(count)为长度
            map.put(0, -1);
            int maxlen = 0, count = 0;
            for (int i = 0; i < nums.length; i++) {
                //1看做1,0看做-1
                count = count + (nums[i] == 1 ? 1 : -1);
                //再次出现相同值说明两次中间含有相同的0和1
                if (map.containsKey(count)) {
                    maxlen = Math.max(maxlen, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }
            return maxlen;
        }
    }