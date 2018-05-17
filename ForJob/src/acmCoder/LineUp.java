package acmCoder;


import java.util.ArrayList;
import java.util.Scanner;

public class LineUp {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            while (n-->0){
                int num=sc.nextInt();
                for (int i:solve(num))
                System.out.print(i+" ");
                System.out.println();
            }
        }
    }
    private static ArrayList<Integer> solve(int n){
        ArrayList<Integer> res=new ArrayList<>();
        if (n<=3){
            while (n-->0){
                res.add(n+1);
            }
        }
        int k1=0,k2=0;
        int num=n;boolean flag=true;
        while (n>3){
            if (flag){
            n-=n/2;k1++;flag=false;
            }else {
                flag=true;
                n-=n/3;k2++;
            }
        }
        System.out.println(k1+"\t"+k2);
        res.add(1);

        return res;
    }
}
