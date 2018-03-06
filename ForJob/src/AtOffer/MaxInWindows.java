package AtOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by yolin on 2018/3/6.
 */
public class MaxInWindows {
    public static void main(String [] args){
        int[] a={1,8,2,5,3,6,7,4,2,9,3,4,7};
        System.out.println(maxInWindows(a,3));
    }
    private static ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> res=new ArrayList<>();
        if (size==0)return res;
       if (num== null || num.length<size || size<1)
        return res;
        LinkedList<Integer> indexDeque=new LinkedList<>();
        for (int i=0;i<size-1;i++){
            // to get the first size window
            while (!indexDeque.isEmpty() && num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        for (int i=size-1;i<num.length;i++){
            while (!indexDeque.isEmpty() && num[i]>num[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i-indexDeque.getFirst()+1>size){
                indexDeque.removeFirst();
            }
            res.add(num[indexDeque.getFirst()]);
        }
        return res;
    }

}
