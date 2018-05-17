package CrackingtheCodingInterview;

import java.util.Scanner;

public class DavisStaircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(solve(n));
        }
    }
    private static int solve(int n){
        int f1=1,f2=2,f3=4;
        for (int i=0;i<n-1;i++){
            f3=f1+f2+f3;
            f2=f3-f1-f2;
            f1=f3-f1-f2;
        }
        return f1;
    }
}
