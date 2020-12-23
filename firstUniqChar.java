class Solution {
        public int firstUniqChar(String s) {
           //不重复字符下标默认为字符串长度
            int result = s.length();
            //只循环了26次
            for (char c = 'a'; c <= 'z' ; c++) {
                int firstIndex = s.indexOf(c);
                int lastIndex = s.lastIndexOf(c);
                //第一次出现的位置和最后一次出现的位置相等表示不重复
                if(lastIndex == firstIndex && firstIndex != -1 ){
                    //比较较小的索引，因为需要找到第一个不重复的
                    result = Math.min(firstIndex,result);
                }
            }
            if(result != s.length()){
                //result不是默认值，说明存在不重复字符返回result
                return result;
            }
            //result是默认值，不存在不重复字符
            return -1;
        }
    }