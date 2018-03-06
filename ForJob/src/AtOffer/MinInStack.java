package AtOffer;

import java.util.Stack;

/**
 * Created by yolin on 2018/1/23.
 */
public class MinInStack {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> min=new Stack<Integer>();
    public void push(int node){
        stack.push(node);
        if (min.isEmpty()){
            min.push(node);
        }else {
            int temp=min.peek();
            if (temp>=node)min.push(node);
        }
    }
    public void pop(){
        int temp=stack.pop();
        if (temp==min.peek()){
            min.pop();
        }
    }
    public int top(){
        return stack.peek();
    }
    public int min(){
        return min.peek();

    }
    public static void main(String[] args){
        int[] a={6,4,9,2,3,5,1,7,8};
        MinInStack st=new MinInStack();
        for (int i:a){
            st.push(i);
            System.out.println(st.top()+"\t"+st.min.toString());
        }

    }
}
