package AtOffer;


import java.util.Stack;

/**
 * Created by yolin on 2018/1/15.
 *
 */
public class isPopOrder {

    public static void main(String[] args){
        int[] inorder={1,2,3,4,5};
        int[] outorder={4,5,3,2,1};
        System.out.println(IsPopOrder(inorder,outorder));
        System.out.println(IsPopOrder1(inorder,outorder));

    }
    private static boolean IsPopOrder(int [] pushA,int [] popA) {
        int[] pop=new int[pushA.length];
        boolean flag=true;
        int k=0,in=0,out=0;
        while (k<popA.length){
            int t=popA[k];
            if (out==0){
                int temp=pushA[in];
                pop[out]=temp;
                out++;
                in++;
            }
            while (pop[out-1]!=t && in<pushA.length){
                int temp=pushA[in];
                pop[out]=temp;
                out++;
                in++;
            }
           // System.out.println(Arrays.toString(pop)+"\t"+t+"\t"+pop[out-1]);
            if (pop[out-1]==t){
                pop[out-1]=0;
                out--;
            }else flag=false;
            k++;
        }

        return flag;
    }
    private static boolean IsPopOrder1(int [] pushA,int [] popA){
        if (pushA.length!=popA.length) return false;
        Stack<Integer> stack=new Stack<>();
        for (int i=0,j=0;i<pushA.length;){
                stack.push(pushA[i++]);
            while (j<popA.length && stack.peek()==popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }
}
