// Brute force solution - O(n*k)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];

        int lp=0;
        int rp=0;
        int p=0;

        while(rp<n){
            if(rp-lp+1>k){
                lp++;
            }

            int max=Integer.MIN_VALUE;
            for(int i=lp;i<=rp;i++){
               max=Math.max(max,nums[i]); 
            }

            if(rp-lp+1==k){
                ans[p]=max;;
                p++;
            }

            rp++;
        }

        return ans;
    }
}


// Optimized  : O(2n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];

        Deque<Integer> dq=new ArrayDeque<>();

        int lp=0;
        int rp=0;
        int p=0;

        while(rp<n){

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[rp]){
                dq.removeLast();
            }

            dq.addLast(rp);

            if(dq.peekFirst()<lp){
                dq.removeFirst();
            }


            if(rp-lp+1>=k){
                ans[p]=nums[dq.peekFirst()];
                p++;
                lp++;
            }

            rp++;
        }

        return ans;
    }
}
