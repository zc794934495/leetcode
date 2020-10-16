class Solution {
    public static int[] sortedSquares(int[] A) {
        if(A == null){
            return null;
        }
        int[] nums = new int[A.length];
        int mark = -1;
        for(int i = 0;i < A.length;i++){
            if(A[i] < 0){
                mark = i;
            } else{
                break;
            }
        }
        int front = mark;
        int back = mark + 1;
        int i = 0;
        while(front >= 0 || back < A.length){
            if(front < 0) { //负数的平方添加完了
                nums[i] = A[back] * A[back];
                back++;
            }else if(back >= A.length){ //正数的平方添加完了
                nums[i] = A[front] * A[front];
                front--;
            }else if((A[front] * A[front]) <= (A[back] * A[back])){ //都没添加完比大小
                nums[i] = A[front] * A[front];
                front--;
            }else {
                nums[i] = A[back] * A[back];
                back++;
            }
            i++;
        }
        return nums;
    }
}