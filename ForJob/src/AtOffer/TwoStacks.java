package AtOffer;

import java.util.Stack;

/**
 * Created by lenovo on 2018/1/14.
 */
public class TwoStacks {
   static Stack<Integer> stack1 = new Stack<>();
   static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 7, 5, 9, 6, 8, 1};
        int n=2;
        for (int i =0;i<n;i++) {
            push(a[i]);
        }
        for (int i = 0; i < n-1; i++) {
            System.out.println(pop()+"*");
        }
        for (int i =0;i<2*n;i++) {
            push(a[i+2]);
        }
        for (int i = 0; i < 2+n; i++) {
            System.out.println(pop()+"#");
        }
    }

    public static void push(int node) {
            stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()){
        while (!stack1.isEmpty()){
            int node=stack1.pop();
            stack2.push(node);
        }
        }
       return stack2.pop();
    }
}
