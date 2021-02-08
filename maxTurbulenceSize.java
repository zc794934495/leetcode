class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n < 2) {
            return n;
        }
        //前一个数字以增加结尾的长度为1
        int increased = 1;
        //前一个数字以减少结尾的长度为1
        int decreased = 1;

        int res = 0;
        for(int i = 1;i < n;i++) {
            if(arr[i] > arr[i - 1]) { //当前是增加的，则以减少结尾的长度+1
                increased = decreased + 1;
                decreased = 1;
            }else if(arr[i] < arr[i - 1]) { //当前是减少的，则以增加结尾的长度+1
                decreased = increased + 1;
                increased = 1;
            }else { //重新初始化
                decreased = 1;
                increased = 1;
            }
            res = Math.max(res,Math.max(decreased,increased));
        }
        return res;
    }
}