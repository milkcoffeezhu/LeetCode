/**
 * @Author: zxs
 * @Date: 2019/8/27 23:43
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
  		int m = nums2.length;

        if (n > m){
            return findMedianSortedArrays(nums2,nums1);
        }

        int lMax1 = Integer.MIN_VALUE;
        int lMax2 = Integer.MIN_VALUE;
        int rMin1 = Integer.MAX_VALUE;
        int rMin2 = Integer.MAX_VALUE;
        int c1, c2, lo = 0, hi = 2 * n;

        while (lo <= hi) {
  			c1 = (lo + hi) / 2;
  			c2 = m + n - c1;

  			lMax1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
  			rMin1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
  			lMax2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
  			rMin2 = (c2 == 2 * m) ?Integer.MAX_VALUE : nums2[c2 / 2];

  			if (lMax1 > rMin2){
                hi = c1 - 1;
            } else if (lMax2 > rMin1){
                lo = c1 + 1;
            } else{
                break;
            }

         }
        int left = Integer.max(lMax1, lMax2);
        int right = Integer.min(rMin1, rMin2);
  		return ( left + right ) / 2.0;
    }

    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }
}
