
// time complexity -O(n)
// space complexity- O(n)

class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();


        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        return set.size()!=nums.length;
    }
}