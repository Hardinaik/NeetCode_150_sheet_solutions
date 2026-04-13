//Brute Force time : O(n^2) , space=O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int n=s.length();

        int max=0;

        for(int i=0;i<n;i++){
            HashSet<Character> set=new HashSet<>();
            for(int j=i;j<n;j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                    max=Math.max(max,j-i+1);
                }
            }
        }

        return max;
    }
}

// optimal : time - O(2n) space:O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int n=s.length();
        int max=0;
        int lp=0;
        int rp=0;

        HashSet<Character> set=new HashSet<>();

        while(rp<n){

            while(set.contains(s.charAt(rp))){
                set.remove(s.charAt(lp));
                lp++;
            }
            
            set.add(s.charAt(rp));
            max=Math.max(max,rp-lp+1);
            
            rp++;
        }

        return max;
    }
}


// Optimized best: Time - O(n) , space- O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int n=s.length();
        int max=0;
        int lp=0;
        int rp=0;

        HashMap<Character,Integer> map=new HashMap<>();

        while(rp<n){

            if(map.containsKey(s.charAt(rp))){
                lp=Math.max(lp,map.get(s.charAt(rp))+1); // check "abba" to understand this
            }
            
            map.put(s.charAt(rp),rp);
            max=Math.max(max,rp-lp+1);
            
            rp++;
        }

        return max;
    }
}
