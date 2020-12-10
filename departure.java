import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < n;i++) {
                nums[i] = sc.nextInt();
            }
            List<String> res = new ArrayList<>();
            Stack<Integer> stack = new Stack<Integer>();
            departure(nums,0,stack,"",0,res);
            Collections.sort(res);
            for(String str : res) {
                System.out.println(str);
            }
        }
    }

    public static void departure(int[] nums,int i,Stack<Integer> stack,String str,int n,List<String> res) {
        if (n == nums.length) {
            res.add(str);   //如果所有火车均出栈则将当前结果保存
        }
        //栈非空时出栈
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            departure(nums, i, stack, str + temp + " ", n + 1, res);
            stack.push(temp);
        }
        //若所有火车没有都入栈则入栈
        if (i < nums.length) {
            stack.push(nums[i]);
            departure(nums, i + 1, stack, str, n, res);
            stack.pop();
        }
    }
}