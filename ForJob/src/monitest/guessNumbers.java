package monitest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class guessNumbers {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            ArrayList<Integer> a=new ArrayList<>();
            for (int i=2;i<=n;i++){
                boolean flag=true;
                for (int j=2;j<=i/2;j++){
                    if (i%j==0){
                        flag=false;break;
                    }
                }
                if (flag)a.add(i);
            }
            long res=1;
            for (int i:a){
                int t=i*i;
                int temp=1;
                while (t<=n){
                    t=t*i;
                    temp+=1;
                }
                res*=(temp+1);
                if (res>=1000000007){
                    res%=1000000007;
                }
            }
            //System.out.println(c1+"\t"+cnt);
            DecimalFormat df=new DecimalFormat("#0");
            System.out.println(df.format(res));
        }
    }
}
