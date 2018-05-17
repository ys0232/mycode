package DynamicProgrammingDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class pureStr {
    static long res=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            res=0;
            if (n==2)res=9;
            else if (n==3)res=21;
            else {
                ArrayList<Character> ch=new ArrayList<>();
                solve(n,0,ch);
            }

        }
    }
    private static void solve(int n,int cur,ArrayList<Character> ch){
        if (cur>n)return;
        char[] chs="ABC".toCharArray();
        for (char i:chs){

        }



    }
}
