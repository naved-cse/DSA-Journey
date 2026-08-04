class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. THE GOLDEN RULE: We always want to binary search on the SMALLER array.
        // If nums1 is bigger, we just swap them!
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        
        // The quota of elements we need on the Left side of our wall
        int quota = (total + 1) / 2; 

        // Binary Search pointers (representing HOW MANY elements we take from nums1)
        int left = 0;
        int right = m;

        while (left <= right) {
            // 2. MAKE THE CUTS
            int cut1 = left + (right - left) / 2; // Guess how many to take from nums1
            int cut2 = quota - cut1;              // Take the rest from nums2

            // 3. GET THE 4 EDGE NUMBERS AROUND THE WALL
            // Remember the "Bottomless Pit" from the Peak Element problem? 
            // If we take 0 elements from an array, we pretend the edge is -Infinity.
            // If we take ALL elements, we pretend the edge is +Infinity.
            
            int maxLeft1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int minRight1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int maxLeft2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int minRight2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // 4. THE X-CHECK ⚔️
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // WE FOUND THE PERFECT CUT!
                
                // If the total length is ODD, the median is just the biggest number on the left.
                if (total % 2 != 0) {
                    return Math.max(maxLeft1, maxLeft2);
                } 
                // If the total length is EVEN, average the max left and min right.
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } 
            // 5. FIXING A BAD CUT
            else if (maxLeft1 > minRight2) {
                // The number from nums1's left side is too big!
                // We took too many elements from nums1. Move cut to the left.
                right = cut1 - 1;
            } else {
                // We didn't take enough elements from nums1. Move cut to the right.
                left = cut1 + 1;
            }
        }
        
        return 0.0; // Code should never actually reach here
    }
}