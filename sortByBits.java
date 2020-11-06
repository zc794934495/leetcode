class Solution {
public int[] sortByBits(int[] arr) {
        int[][] temp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = arr[i];
            temp[i][1] = hammingWeight(arr[i]);
        }
        insertSort(temp);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i][0];
        }
        return arr;
    }

    private void insertSort(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            int[] temp = array[i];
            for (j = i - 1; j >= 0; j--) {
                //先比较位1的大小，如果相同再比较数字的大小
                if (array[j][1] > temp[1] || (array[j][1] == temp[1] && array[j][0] > temp[0])) {
                    array[j + 1] = array[j];//往后挪
                } else {
                    break;//没有交换就break
                }
            }
            array[j + 1] = temp;
        }
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}