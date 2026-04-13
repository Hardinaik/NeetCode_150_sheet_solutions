
// Time complexity : O(1) per fucntion call space: O(2n)
class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack() {
        s=new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty()){
            min.push(val);
        }
        else{
            min.push(Math.min(min.peek(),s.peek()));
        }
    }
    
    public void pop() {
       
        s.pop();
        min.pop();
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
