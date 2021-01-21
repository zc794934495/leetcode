import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            double num1 = factorial(n);
            double num2 = derangement(n);
            double res = (num2/num1)*100;
            System.out.println(String.format("%.2f",res)+"%");
        }
    }
    public static double factorial(int n) {
        double res = 1;
        while(n > 1) {
            res *= n;
            n--;
        }
        return res;
    }
    public static double derangement(int n) {
        if(n == 1) {
            return 0;
        }else if(n == 2) {
            return 1;
        }
        return (n - 1) * (derangement(n - 1) + derangement(n - 2));
    }
}
