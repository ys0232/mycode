package solveAtNiuKe;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/10.
 */
public class printColors {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println(print(n,m));
        }

    }
    private static BigInteger print(int n,int m){
        if (n<1)return BigInteger.valueOf(0);
        if (n==1)return BigInteger.valueOf(1);
        if (n==2)return BigInteger.valueOf(m*(m-1));
        int k=n;
        BigInteger res=new BigInteger("1");
        while (k-->0){
            res=BigInteger.valueOf(m-1).multiply(res);
        }
        if (n%2==1){
            res=res.subtract(BigInteger.valueOf(m-1));
        }else  res=res.add(BigInteger.valueOf(m-1));
        return res;
    }
}
