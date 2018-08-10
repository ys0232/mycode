package CodeM;

import java.util.Scanner;

public class CombineString_2017B {
   public static void main(String [] args){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       while (n-->0){
           String s1=sc.next();
           String s2=sc.next();
           char[] ch1=s1.toCharArray();
           char[] ch2=s2.toCharArray();
           int[] cnt1=new int[4];
           int[] cnt2=new int[4];
           for (int i=0;i<ch1.length;i++){
               switch (ch1[i]){
                   case 'A':cnt1[0]+=1;break;
                   case 'C':cnt1[1]+=1;break;
                   case 'G':cnt1[2]+=1;break;
                   case 'T':cnt1[3]+=1;break;
               }
           }
           for (int i=0;i<ch2.length;i++){
               switch (ch1[i]){
                   case 'A':cnt2[0]+=1;break;
                   case 'C':cnt2[1]+=1;break;
                   case 'G':cnt2[2]+=1;break;
                   case 'T':cnt2[3]+=1;break;
               }
           }

       }
   }
}
