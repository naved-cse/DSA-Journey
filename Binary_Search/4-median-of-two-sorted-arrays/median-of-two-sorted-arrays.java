class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int quota = (total + 1) / 2;

        int left = 0;
        int right = m;

        while ( left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = quota - cut1;

            int maxLeft1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int minRight1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int maxLeft2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int minRight2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if(total % 2 != 0){
                    return Math.max(maxLeft1, maxLeft2);
                }
                else{
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            }
            else if(maxLeft1 > minRight2){
                right = cut1 - 1;
            }else {
                left = cut1 + 1;
            }
        }
        return 0.0;
    }
}