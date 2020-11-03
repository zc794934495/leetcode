import java.util.*;

public class Joseph {
    public int getResult(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1;i <= n;i++) {
            list.add(i);
        }
        int k = 2;
        int i = 0;
        int curr = 0;
        while(list.size() != 1) {
            i = 0;
            while (list.size() > 1 && i < list.size()) {
                curr = (curr + 1) % k;
                if (curr != 1){//报数不是1就删除
                    list.remove(i);
                }else{
                    i++;
                }
            }
            k++;
            curr = 0;
            //链表中最后一个元素放到链表头
            if (list.size() > 1) {
                int last = list.removeLast();
                list.addFirst(last);
            }
        }
        return list.pop();
    }
}