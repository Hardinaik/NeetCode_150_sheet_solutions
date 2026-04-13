class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();

        int n=tokens.length;

        for(int i=0;i<n;i++){
            String str=tokens[i];

            if(str.equals("+")){
                int num2=s.pop();
                int num1=s.pop();

                s.push(num1+num2);
            }else if(str.equals("-")){
                int num2=s.pop();
                int num1=s.pop();

                s.push(num1-num2);
            }
            else if(str.equals("*")){
                int num2=s.pop();
                int num1=s.pop();

                s.push(num1*num2);
            }else if(str.equals("/")){
                int num2=s.pop();
                int num1=s.pop();

                s.push(num1/num2);
            }else{
                int num=Integer.parseInt(str);
                s.push(num);
            }
        }

        return s.peek();
    }
}
