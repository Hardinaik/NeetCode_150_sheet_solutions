// Brute force : check for every substring : O(n^2 * m(compare hashmaps))

//Optimized: O(n+m), spcae:O(n+m)

class Solution {
    public String minWindow(String s, String t) {
        int hash1[]=new int[256];
        int hash2[]=new int[256];

        
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hash1[ch]+=1;
        }

        int cnt=0;

        for(int i=0;i<256;i++){
            if(hash1[i]>0){
                cnt++;
            }
        }

        
        int lp=0;
        int rp=0;

        int matches=0;
        int len=Integer.MAX_VALUE;
        String ans="";

        while(rp<s.length()){
            char ch=s.charAt(rp);
            
            if(hash1[ch]>0){
                hash2[ch]+=1;

                if(hash1[ch]==hash2[ch]){
                    matches++;
                }
            }

            while(matches==cnt){

                if(rp-lp+1<len){
                    len=rp-lp+1;
                    ans=s.substring(lp,rp+1);
                }

                char left_ch=s.charAt(lp);
                if(hash1[left_ch] > 0){
                    hash2[left_ch]--;

                    if(hash2[left_ch] < hash1[left_ch]){
                        matches--;
                    }
                }

                lp++;
            }

            rp++;
        }

        return len==Integer.MAX_VALUE?"":ans;
    }
}

// single array
class Solution {
    public String minWindow(String s, String t) {
        int hash[]=new int[256];
        
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hash[ch]+=1;
        }

       
        
        int lp=0;
        int rp=0;

        int required=t.length();
        int len=Integer.MAX_VALUE;
        String ans="";

        while(rp<s.length()){
            char ch=s.charAt(rp);

            if(hash[ch]>0){
                required--;
            }

            hash[ch]-=1;

            while(required==0){

                if(rp-lp+1<len){
                    len=rp-lp+1;
                    ans=s.substring(lp,rp+1);
                }

                char left_ch=s.charAt(lp);
                hash[left_ch]+=1;

                if(hash[left_ch]>0){
                    required++;
                }

                lp++;
            }

            rp++;
        }

        return len==Integer.MAX_VALUE?"":ans;
    }
}
