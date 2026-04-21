// BruteForce : Time : O(n^2*26) Space:O(26) 

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int hash1[]=new int[26];
       

        for(int i=0;i<s1.length();i++){
            hash1[s1.charAt(i)-'a']+=1;
        }

        for(int i=0;i<s2.length();i++){
            int hash2[]=new int[26];
            
            for(int j=i;j<s2.length();j++){
                hash2[s2.charAt(j)-'a']+=1;
            
                boolean fg=true;
                for(int k=0;k<26;k++){
                    if(hash2[k]!=hash1[k]){
                        fg=false;
                        break;
                    } 
                }

                if(fg){
                    return true;
                }

            }
        }

        return false;
    }
}


//better - Time : O(n*26) Space:O(26)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int hash[]=new int[26];
       

        for(int i=0;i<s1.length();i++){
            hash[s1.charAt(i)-'a']+=1;
        }

        int lp=0;
        int rp=0;

        while(rp<s2.length()){
            char ch=s2.charAt(rp);
            hash[ch-'a']-=1;

            if(rp-lp+1>s1.length()){
                hash[s2.charAt(lp)-'a']+=1;
                lp++;
            }


            int cnt=0;
            for(int i=0;i<26;i++){
                if(hash[i]==0){
                    cnt++;
                }
            }

            if(cnt==26){
                return true;
            }

            rp++;
        }

        return false;
    }
}

//Optimal : Time : O(n) , space : O(26)

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int hash1[]=new int[26];
        int hash2[]=new int[26];
       
        if(s2.length()<s1.length())return false;

        for(int i=0;i<s1.length();i++){
            hash1[s1.charAt(i)-'a']+=1;
            hash2[s2.charAt(i)-'a']+=1;
        }


        int matches=0;
        for(int i=0;i<26;i++){
            if(hash1[i]==hash2[i]){
                matches++;
            }
        }

        

        int lp=0;
        int rp=s1.length();

        while(rp<s2.length()){
           if(matches==26) return true;

           char ch=s2.charAt(rp);
           hash2[ch-'a']+=1;

           if(hash1[ch-'a']==hash2[ch-'a']){
              matches+=1;
           }
           else if(hash1[ch-'a'] +1 ==hash2[ch-'a']){
                matches-=1;
           }

           ch=s2.charAt(lp);
           hash2[ch-'a']-=1;

           if(hash1[ch-'a']==hash2[ch-'a']){
              matches+=1;
           }
           else if(hash1[ch-'a']-1 ==hash2[ch-'a']){
                matches-=1;
           }

           

           lp++;
           rp++;

        
        }

        if(matches==26) return true;

        return false;
    }
}
