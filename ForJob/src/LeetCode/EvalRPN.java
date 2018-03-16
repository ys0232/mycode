package LeetCode;

import java.util.Stack;

/**
 * Created by yolin on 2018/3/14.
 */
public class EvalRPN {
    public static void main(String [] args){
        String[] s={"4","13","5","/","+"};
        System.out.println(evalRPN(s));
    }
    private static int evalRPN(String[] tokens){
        Stack<Integer> st=new Stack<>();
        //int sum=0;
        for (int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if (s.equals("+")){
                int a=st.pop() ;
                int b=st.pop();
                st.push((a+b));
            }else if (s.equals("-")){
                int a=st.pop() ;
                int b=st.pop();
                st.push((b-a));
            }else if (s.equals("*")){
                int a=st.pop() ;
                int b=st.pop();
                st.push((a*b));
            }else if (s.equals("/")){
                int a=st.pop() ;
                int b=st.pop();
                st.push((b/a));
            }else st.push(Integer.valueOf(s));
        }
        return st.pop();
    }
}
