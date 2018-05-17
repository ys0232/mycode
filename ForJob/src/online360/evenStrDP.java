package online360;

import java.util.Arrays;
import java.util.Scanner;

public class evenStrDP {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            int[] dp=new int[str.length()];
            long res=0;
            dp[0]=(int)Math.pow(2,str.charAt(0)-'a');
            for (int i=1;i<str.length();i++){
                for (int j=0;j<=i;j++){
                    dp[i]=dp[i-1]^(int)Math.pow(2,str.charAt(j)-'a');
                }
                System.out.println(Arrays.toString(dp));
                if (dp[i]==0)res+=1;
            }
            System.out.println(res);
        }
    }
}
