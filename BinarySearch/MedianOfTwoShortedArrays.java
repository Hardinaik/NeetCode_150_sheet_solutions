// Brute force : Time : O(n+m) , space : O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int i=0;
        int j=0;
        int k=0;

        int idx2= (n+m)/2;
        int idx1= idx2-1;

        int el1=0;
        int el2=0;

        int el=0;

        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                el=nums1[i];
                i++;
            }else{
                el=nums2[j];
                j++;
            }

            if(k==idx1){
                el1=el;
            }

            if(k==idx2){
                el2=el;
            }

            k++;
        }

        while(i<n){
            if(k==idx1){
                el1=nums1[i];
            }

            if(k==idx2){
                el2=nums1[i];
            }
            i++;
            k++;
        }


         while(j<m){
            if(k==idx1){
                el1=nums2[j];
            }

            if(k==idx2){
                el2=nums2[j];
            }
            j++;
            k++;
        }

        if((n+m)%2 !=0)return (double)el2;

        return (el1+el2)/2.0;
    }
}


// Optimised approach : Time : log(min(n,m)), space :O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = n;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            int r1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}