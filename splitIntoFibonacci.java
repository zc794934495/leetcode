class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrack(S,res,S.length(),0,0,0);
        return res;
    }

    //S：数字字符串
    //res:结果集合
    //length:数字字符串长度
    //index:拆分出来的数字的开头数字下标
    //sum:前两位的和
    //prev:前一个数字
    public boolean backtrack(String S,List<Integer> res,int length,int index,int sum,int prev) {
        //遍历结束res至少有三个数则返回true
        if(index == length) {
            return res.size() >= 3;
        }
        //因为题目给的是字符串，可能超过整型最大值
        long longCur = 0;
        for(int i = index;i < length;i++) {
            //以0开头，但不是0本身
            if(i > index && S.charAt(index) == '0') {
                break;
            }
            longCur = longCur * 10 + S.charAt(i) - '0';
            //数字超过整型最大值
            if(longCur > Integer.MAX_VALUE) {
                break;
            }
            int cur = (int)longCur;
            //已经有两个数
            if(res.size() > 1) {
                //cur>sum时不需要继续拆分
                if(cur < sum) {
                    continue;
                }else if(cur > sum){
                    break;
                }
            }
            res.add(cur);
            if(backtrack(S,res,length,i + 1,cur + prev,cur)) { //当前拆分满足菲波那切数列
                return true;
            }else{ //回溯
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}