class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        //将ab的和作为key，出现次数作为value添加到map
        for(int numA : A) {
            for(int numB : B) {
                map.put(numA + numB,map.getOrDefault(numA + numB,0) + 1);
            }
        }
        int count = 0;
        //将0减cd的和作为检索条件，存在则有对应value个元组
        for(int numC : C) {
            for(int numD : D) {
                if(map.containsKey(0 - numC -numD)) {
                    count += map.get(0 - numC - numD);
                }
            }
        }
        return count;
    }
}