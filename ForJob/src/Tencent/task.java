package Tencent;

import java.util.Scanner;

public class task {
   public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       while (sc.hasNext()){

           int t1=sc.nextInt();
           int t2=sc.nextInt();
           if (t1<1 || t1>1024 &&(t2<1 || t2>1024)){
               System.out.println(-1);
           }else if (t1!=t2){
               System.out.println(0);
           }else System.out.println(1);
       }
   }
}
