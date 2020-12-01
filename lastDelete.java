import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(lastDelete(num));
        }
    }
    
    public static int lastDelete(int num) {
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = 0;i < num;i++) {
            res.addLast(i);
        }
        int count = 0;
        while(res.size() > 1) {
            Deque<Integer> stack = new LinkedList<>();
            for(int i = 0;i < res.size();i++) {
                if(count == 2) {
                    //先记录下要删除的位置，一会倒序删除
                    stack.addFirst(i);
                    count = -1;
                }
                count++;
            }
            //倒序删除
            while(!stack.isEmpty()) {
                //不强转为int会默认调用remove(Object 0)方法，而不是remove(int index)方法
                res.remove((int)stack.pop());
            }
            //将尾部元素放到头部
            res.addFirst(res.removeLast());
            //下一次要从0号下标开始的时候要再数一遍原尾部元素
            count--;
        }
        return res.removeLast();
    }
}