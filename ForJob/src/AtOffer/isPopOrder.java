package AtOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yolin on 2018/1/15.
 *
 */
public class isPopOrder {

    public static void main(String[] args){
        int[] inorder={1,2,3,4,5};
        int[] outorder={4,3,5,1,2};
        System.out.println(IsPopOrder(inorder,outorder));

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
}
