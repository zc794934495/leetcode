class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m  = nums1.length;
        int n = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0,k - n);//一个都不取或者取另一个数组取完还缺的
        int end = Math.min(k,m);//全取或者取k个
        //遍历所有可能的k组成
        for(int i = start;i <= end;i++) {
            //获取nums1保留i个数的最大子序列
            int[] subsequence1 = maxSubsequence(nums1,i);
            //获取nums2保留k - i个数的最大子序列
            int[] subsequence2 = maxSubsequence(nums2,k - i);
            //合并两个最大子序列，变为当前最大数
            int[] curMaxSubsequence = merge(subsequence1,subsequence2);
            if(compare(curMaxSubsequence,0,maxSubsequence,0) > 0) {
                //当前把当前最大数copy到最大数
                System.arraycopy(curMaxSubsequence,0,maxSubsequence,0,k);
            }
        }
        return maxSubsequence;
    }
    //获取数组保留k个数字的最大子序列，单调栈（递减）实现
    public int[] maxSubsequence(int[] nums,int k) {
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        //需要删除多少个数字
        int remain = len - k;
        for(int i = 0;i < len;i++) {
            int num = nums[i];
            while(!stack.isEmpty() && stack.peekLast() < num && remain > 0) {
                stack.pollLast();
                remain--;
            }
            stack.offerLast(num);
        }
        //保留数字大于k个，则从末尾开始删
        while(remain != 0) {
            stack.pollLast();
            remain--;
        }

        int[] res = new int[k];
        int index = 0;
        while(!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
    //合并两个数组，使结果数组最大
    public int[] merge(int[] subsequence1,int[] subsequence2) {
        int m = subsequence1.length;
        int n = subsequence2.length;
        if(m == 0) {
            return subsequence2;
        }
        if(n == 0) {
            return subsequence1;
        }
        int len = m + n;
        int[] merged = new int[len];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0;i < len;i++) {
            if(compare(subsequence1,index1,subsequence2,index2) > 0) {
                merged[i] = subsequence1[index1++];
            }else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }
    //比较nums1从i开始和nums2从j开始所表示的数字大小
    public int compare(int[] nums1,int i,int[] nums2,int j) {
        int m = nums1.length;
        int n = nums2.length;
        while(i < m && j < n) {
            if(nums1[i] != nums2[j]) {
                return nums1[i] - nums2[j];
            }else {
                i++;
                j++;
            }
        }
        //返回i到m 和 j到n的长度比较结果
        return (m - i) - (n - j);
    }
}