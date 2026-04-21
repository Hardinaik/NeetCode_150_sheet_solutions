// Why binary search : finding minimum or maximum in array . and we have upper and lower bound for answer.
//Time : O(nlog(m))
class Solution {
    public int count_hrs(int piles[],int k){
        int hrs=0;
        for(int i=0;i<piles.length;i++){
            hrs+=piles[i]/k;
            hrs+=(piles[i]%k!=0)?1:0;
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        int ans=-1;

        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            if(count_hrs(piles,mid)>h){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }

        return ans;
    }
}
