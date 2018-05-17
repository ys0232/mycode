package online360;

import java.util.Scanner;

public class MathExpection {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            double res=0;
            for (int i=0;i<n;i++){
                int x=sc.nextInt();
                int p=sc.nextInt();
                res+=x*p;
            }
            System.out.println(String.format("%.3f",res/100));

        }
    }
}
