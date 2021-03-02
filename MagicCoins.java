import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> stack = new LinkedList<Integer>();
        while(n > 0) {
            if(n % 2 == 0) {
                stack.push(2);
                n -= 2;
            } else {
                stack.push(1);
                n -= 1;
            }
            n /= 2;
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}