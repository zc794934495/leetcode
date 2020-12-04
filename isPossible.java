class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        Map<Integer,Integer> endMap = new HashMap<>();
        //存入计数map中
        for(int num : nums) {
            countMap.put(num,countMap.getOrDefault(num,0) + 1);
        }

        for(int num : nums) {
            //取当前num剩余个数
            int count = countMap.getOrDefault(num,0);
            if(count > 0) {
                //取以当前num-1结尾的子序列个数
                int preEndCount = endMap.getOrDefault(num - 1,0);
                if(preEndCount > 0) { //存在，将这个num划入以num-1结尾的子序列中，变为以num结尾的子序列
                    //num剩余个数-1
                    countMap.put(num,count - 1);
                    //以num-1结尾个数-1
                    endMap.put(num - 1,preEndCount - 1);
                    //以num结尾个数+1
                    endMap.put(num,endMap.getOrDefault(num,0) + 1);
                }else{ //不存在，则需要以num，num+1，num+2组成新的子序列（组成长度至少为3）
                    int count1 = countMap.getOrDefault(num + 1,0);
                    int count2 = countMap.getOrDefault(num + 2,0);
                    if(count1 != 0 && count2 != 0) { //num+1，num+2都有剩余个数
                        //三个数的剩余个数-1
                        countMap.put(num,count - 1);
                        countMap.put(num + 1,count1 - 1);
                        countMap.put(num + 2,count2 - 1);
                        //以num+2结尾个数+1
                        endMap.put(num + 2,endMap.getOrDefault(num + 2,0) + 1);
                    }else { //num+1，num+2剩余个数不足
                        return false;
                    }
                }
            }
        }
        return true;
    }
}