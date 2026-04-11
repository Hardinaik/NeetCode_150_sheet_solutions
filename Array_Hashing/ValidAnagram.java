class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int n=s.length();
        int hash1[]=new int[26];
        int hash2[]=new int[26];

        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            hash1[ch1-'a']+=1;
            hash2[ch2-'a']+=1;
        }

    
        for(int i=0;i<26;i++){
            if(hash1[i]!=hash2[i]){
                return false;
            }
        }

        return true;
    }
}
