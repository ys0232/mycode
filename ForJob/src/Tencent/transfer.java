package Tencent;

import java.util.Scanner;

public class transfer {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int low=-90,high=90;
            int k=0;String res="";
            while (low<high && k<6){
                k+=1;
                int mid=(low+high)/2;
                if (n<mid){
                    high=mid;
                    res+=String.valueOf(0);
                }else {
                    low=mid;
                    res+=String.valueOf(1);
                }
            }
            System.out.println(res);
        }
    }
}
