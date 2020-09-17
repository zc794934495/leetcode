class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] intervals1,int[] intervals2){
                return intervals1[0] - intervals2[0];
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        for(int i = 0;i < intervals.length;i++){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(list.size() == 0 || list.get(list.size() - 1)[1] < L){
                list.add(intervals[i]);
            }else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}