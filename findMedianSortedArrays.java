class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int aStart = 0;
        int bStart = 0;
        int len = m + n;
        int right = -1;
        int left = -1;
        for(int i = 0;i < len / 2;i++){
            left = right;
            if(aStart < m && (bStart >= n || nums1[aStart] > nums2[bStart])){
                right = nums1[aStart++];
            }else{
                right = nums2[bStart++];
            }
        }
        if((len & 1) == 0){
            return (right + left) / 2.0;
        }else{
            return right;
        }
    }
}