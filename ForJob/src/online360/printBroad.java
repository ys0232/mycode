package online360;

import java.util.Scanner;

public class printBroad {
   public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       while (sc.hasNext()){
           int t=sc.nextInt();
           while (t-->0){
               int n=sc.nextInt();
               int res=0;
               for (int i=0;i<n;i++){
                   int x1=sc.nextInt();int y1=sc.nextInt();
                   int x2=sc.nextInt();int y2=sc.nextInt();
                   res+=(x2-x1+1)*(y2-y1+1);
               }
               System.out.println(res);
           }

       }
   }
}
