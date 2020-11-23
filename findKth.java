import java.util.*;

public class Finder {
    // 思想：快排每一次的基准值都会被放在最终该放的位置上
    // 当倒数第k个元素的位置被确定的时候，就找到了第k个最大的值，无需继续排序
    public static int findKth(int[] a, int n, int K) {
        //n-K为第K个最大的数的下标
        return findKth(a, 0, n-1, n - K);
    }
    public static int findKth(int[] a, int low, int high, int k) {
        int part = partation(a, low, high);
        //当k等于part时，第k大的数已经确定
        if(k == part) {
            return a[part];
        } else if(k > part) { //去右边找第k大的数
            return findKth(a, part + 1, high, k);
        } else { //去左边找第K大的数
            return findKth(a, low, part, k);
        }

    }
    //进行一次升序快排
    public static int partation(int[] a, int low, int high) {
        int key = a[low];
        while(low < high) {
            while(low < high && a[high] >= key) {
                high--;
            }
            a[low] = a[high];
            while(low < high && a[low] <= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
}