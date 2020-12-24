class Solution {
    public int candy(int[] ratings) {
        int sum = 1;
        int prev = 1;
        int inc = 1;
        int dec = 0;
        for(int i = 1;i < ratings.length;i++) {
            if(ratings[i] >= ratings[i - 1]) {
                //递减序列清0
                dec = 0;
                //相等重置为1，大于则多给一颗糖
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                sum += prev;
                inc = prev;
            }else {
                dec++;
                //递减序列和递增序列相同，递增序列的最后一个应该算递减序列的第一个
                if(dec == inc) {
                    dec++;
                }
                //给前面递减序列的孩子补发一颗糖
                sum += dec;
                //给当前孩子一颗糖
                prev = 1;
            }
        }
        return sum;
    }
}