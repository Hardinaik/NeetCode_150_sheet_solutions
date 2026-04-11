class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        ArrayList<Integer> values[]=new ArrayList[n+1];
        //index i represent frq
        //list is elements with that freq

        for(int i=0;i<n+1;i++){
            values[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        for(int key : map.keySet()){
            int freq=map.get(key);
            values[freq].add(key);
        }

        int j=0;
        for(int i=n;i>=0;i--){
            for(int p=0;p<values[i].size();p++){
                ans[j]=values[i].get(p);
                j++;

                if(j>=k){
                    return ans;
                }
            }
        }
        return ans;
    }
}