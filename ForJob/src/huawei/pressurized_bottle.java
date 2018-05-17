package huawei;

import java.util.Scanner;

public class pressurized_bottle {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            if (n==0)break;
            System.out.println(solve(n+1));
        }
    }
    private static int solve(int n){
        int res=n/3;
        while (n>2){
            n=n/3+n%3;
            res+=n/3;
        }
        return res;
    }
}
