class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            //统计26个字母的出现次数
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            //按顺序拼接字母个数和字母作为key
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < 26;i++) {
                if(count[i] != 0) {
                    sb.append(count[i]);
                    sb.append((char)(i + 'a'));
                }
            }
            String key = sb.toString();
            //依据key拿到符合这个key的list
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}