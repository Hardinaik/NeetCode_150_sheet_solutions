// Brute Force - O(nlogn)
// space complexity - O(1)

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;

        Arrays.sort(nums);

        int n=nums.length;
        int max=1;
        int prev=nums[0];
        int i=1;
        int currlen=1;

        while(i<n){
            if(nums[i]==prev+1){
                prev=nums[i];
                currlen++;
                max=Math.max(max,currlen);
            }else if(nums[i]!=prev && nums[i]!=(prev+1)){
                prev=nums[i];
                currlen=1;
            }

            i++;
        }

        return max;



    }
}


//Optimized Time complexity O(n) space complexity - O(n)

//Each number is visited at most once across all while loops

class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

       
        int max=0;

        for(Integer num:set){
           
            if(!set.contains(num-1)){
                int el=num;
                int len=0;

                while(set.contains(el)){
                    len++;
                    el++;
                }

                max=Math.max(len,max);
            }

        }


        return max;
       


    }
}
