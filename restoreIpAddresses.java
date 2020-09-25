class Solution {
    static final int SEG_COUNT = 4;   //字段数
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,0);
        return ans;
    }
    //id：记录当前字段数 start：记录当前字符位置
    public void dfs(String s,int id,int start){
        if(id == SEG_COUNT){//是否达到四个字段
            if(start == s.length()){//字符串是否用完
                StringBuffer ipAddr = new StringBuffer();
                for(int i = 0;i < SEG_COUNT;i++){
                    ipAddr.append(segments[i]);
                    if(i != SEG_COUNT - 1){
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        if(start == s.length()){//没达到四个字段时，字符串是否用完
            return;
        }
        if(s.charAt(start) == '0'){//当前字符为0，让当前字段为0
            segments[id] = 0;
            dfs(s,id + 1,start + 1);
            return;
        }

        int addr = 0;
        for(int end = start;end < s.length();end++){
            addr = addr * 10 + (s.charAt(end) - '0');
            if(addr > 0 && addr <= 0xFF){
                segments[id] = addr;
                dfs(s,id + 1,end + 1);
            }else{
                break;
            }
        }
    }
}