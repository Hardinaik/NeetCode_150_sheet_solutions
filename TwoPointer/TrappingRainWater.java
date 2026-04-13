// Time : O(2n) , Space: O(n)
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int rmax[]=new int[n];
        rmax[n-1]=height[n-1];

        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],height[i]);
        }

        int water=0;
        int lmax=0;

        for(int i=0;i<n;i++){
            lmax=Math.max(lmax,height[i]);
            int w=Math.min(lmax,rmax[i])-height[i];

            water+=w;
        }
        
        return water;
    }
}


// Optimal:

//Optimal Time: O(n) space: O(1)
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lmax=0;
        int rmax=0;

        int lp=0;
        int rp=n-1;

        int water=0;

        while(lp<=rp){
            if(height[lp]<=height[rp]){
                lmax=Math.max(lmax,height[lp]);
                water+=(lmax-height[lp]);
                lp++;
            }else{
                rmax=Math.max(rmax,height[rp]);
                water+=(rmax-height[rp]);
                rp--;
            }
        }
        
        return water;
    }
}
