// time complexity- O(n*m)
// space complexity - O(n) //strs length

class Solution {
  
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();


        int n=strs.length;
        for(int i=0;i<n;i++){
            int hash[]=new int[26];
            String str=strs[i];
            for(int j=0;j<str.length();j++){
                hash[str.charAt(j)-'a']+=1;
            }

            String key = Arrays.toString(hash);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(str);
        }

        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
       

        return ans;
    }
}
