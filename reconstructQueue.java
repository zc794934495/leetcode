class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //按照身高从高到低排序，如果身高相同按k升序排列
        //因为身高高的人不在意身高低的人站在哪里，所以先放身高高的人
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] == person2[0]) {
                    return person1[1] - person2[1];
                } else {
                    return person2[0] - person1[0];
                }
            }
        });
        List<int[]> res = new ArrayList<int[]>();
        //插入每个人到k位置去
        //插入person时，前面的所有人都与person身高相同或者更高
        //此时person[1]就可以理解为person前有多少个人
        //则前面有多少人就站在第几位上
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[res.size()][]);
    }
}