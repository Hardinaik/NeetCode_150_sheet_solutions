//Brute Force: Time : O(n^2),space:O(26)

class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int max=0;
       

        for(int i=0;i<n;i++){
            HashMap<Character,Integer> map=new HashMap<>();
            int mfreq=0;
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                mfreq=Math.max(mfreq,map.get(ch));

                int swaps=j-i+1-mfreq;

                if(swaps<=k){
                    max=Math.max(max,j-i+1);
                }
            }
        }

        return max;
    }
}

// Time complexity: O(n*26),space: O(26)
class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int max=0;
        int mfreq=0;

        int lp=0;
        int rp=0;

        int hash[]=new int[26];

        while(rp<n){
            char ch=s.charAt(rp);
            hash[ch-'A']+=1;

            mfreq=Math.max(mfreq,hash[ch-'A']);

            if(rp-lp+1-mfreq>k){
                hash[s.charAt(lp)-'A']-=1;
                lp++;

                for(int i=0;i<26;i++){
                    mfreq=Math.max(mfreq,hash[i]);
                }

            }else{
                max=Math.max(max,rp-lp+1);
            }

            rp++;

        }
       

        
        return max;
    }
}


//Optimized: 