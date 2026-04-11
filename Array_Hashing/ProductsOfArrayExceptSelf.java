// time complexity - O(n)
class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<strs.size();i++){
            String en=strs.get(i).length()+"#"+strs.get(i);
            sb.append(en);
       }

        System.out.println(sb.toString());
       return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans=new ArrayList<>();

        int i=0;
        int si=0;
        while(i<str.length()){
            if(str.charAt(i)!='#'){
                i++;
            }
            else{
                int len=Integer.parseInt(str.substring(si,i));
                ans.add(str.substring(i+1,i+len+1));
                i=i+len+1;
                si=i;
            }
        }

        return ans;
    }
}