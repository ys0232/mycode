package Tencent;

import java.util.Scanner;

public class coding {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.next();
            int n=s.length();
            int sum=0,cursum=0;
            for (int i=0;i<4;i++){
                cursum*=25;
                if (i<n)
                    cursum+=s.charAt(i)-'a';
                sum+=cursum;
                if (i<n-1)
                    sum+=1;
            }
            System.out.println(sum);
        }
    }
}
