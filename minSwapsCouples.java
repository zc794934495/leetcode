class Solution {
    public int minSwapsCouples(int[] row) {
        int res = 0;
        int[] pos = new int[row.length];

        for (int i = 0; i < pos.length; i++) {
            //每个人对应的位置
            pos[row[i]] = i;  
        }

        for (int i = 0; i < pos.length; i += 2) {
            //异或1：偶数加一，奇数减一，得到情侣
            int pairPerson = row[i] ^ 1;  
            //右边是情侣
            if (row[i + 1] == pairPerson) {
                continue;
            }
            //得到右边的人是谁
            int nextPerson = row[i + 1]; 
            //得到情侣的位置在哪
            int changePos = pos[pairPerson]; 

            //情侣位置坐上了右边的人nextPerson
            row[changePos] = nextPerson;
            //修改nextPerson的位置
            pos[nextPerson] = changePos; 
            res++;
        }

        return res;
    }
}