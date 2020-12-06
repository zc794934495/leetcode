import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int[] num = new int[s.length - 1];
            for (int i = 0; i < s.length - 1; i++) {
                num[i] = Integer.parseInt(s[i]);
            }

            int k = Integer.parseInt(s[s.length - 1]);
            int start = 0;
            int end = num.length - 1;
            //可以选择出index个最小的
            int index = qSort(num, start, end);
            //当index==k，就能选择出k个最小的
            while (index != k) {
                //需要去前半段继续让index趋近于k
                if (index > k) {
                    end = index - 1;
                    index = qSort(num, start, end);
                } else { //去后半段让index趋近与k
                    start = index + 1;
                    index = qSort(num, start, end);
                }
            }
            //对k个最小的排序
            Arrays.sort(num, 0, k);
            for (int i = 0; i < k; i++) {
                System.out.print(i == k - 1 ? num[i] : num[i] + " ");
            }
        }
    }
    
    public static int qSort(int[] num, int start, int end) {
        int dig = num[start];
        while (start < end) {
            while (start < end && num[end] >= dig) {
                end--;
            }
            num[start] = num[end];
            while (start < end && num[start] < dig) {
                start++;
            }
            num[end] = num[start];
        }
        num[start] = dig;
        return start;
    }
}
