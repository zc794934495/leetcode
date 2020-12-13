import java.util.*;

public class UnusualAdd {
    public int addAB(int A, int B) {
        // write code here
        //A（或进位）为0则，只用返回B（或进位与和的和）
        while(A != 0) {
            int temp = B;
            B = A ^ B; // 用B保存不包含进位的和
            A = temp & A; //用A保存进位
            A <<= 1;
        }
        return B;
    }
}