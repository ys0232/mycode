package wangyi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class reduceTheSameNum {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Stack<Integer> res=new Stack<>();
            for (int i=n-1;i>=0;i--){
                if (!res.contains(a[i])){
                    res.add(a[i]);
                }
            }
            while (res.size()>1)
            System.out.print(res.pop()+" ");
            System.out.println(res.pop());
        }
    }
}
