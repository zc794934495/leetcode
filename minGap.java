import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(minGap(n));
        }
    }
    
    public static int minGap(int n) {
        if(n == 0) {
            return 0;
        }
        int count = 0;
        //4*x+3 == 2*(2*x+1)+1 即进行两次2*x+1
        //8*x+7 == 2*(2*(2*x+1)+1)+1 即进行三次2*x+1
        //因为按2*x+1算一次则，最多可以300_000次
        while(n != 0 && count <= 300_000) {
            n = ((n << 1) + 1) % 1_000_000_007;
            count++;
        }
        //尽量按8*x+7算次数
        int res = count / 3;
        //余数为1 需要少移动一次8*x+7，再移动两次4*x+3，即res + 2 - 1 == res + 1
        //余数为2 只需要再移动一次4*x+3，即res + 1
        if(count % 3 != 0) {
            res++;
        }
        return res > 100_000 ? -1 : res;
    }
}