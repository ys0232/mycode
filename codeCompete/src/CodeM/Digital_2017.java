package CodeM;

import java.util.Scanner;

public class Digital_2017 {

    public static void main(String [] args){
        //System.out.println(getFirst(980));
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
         long left=sc.nextLong();
         long right=sc.nextLong();
         long[] res=new long[10];
         //res[1]+=right-left+1;
            int t;
         int end=(int) Math.sqrt(right);
         for (int k=1;k<=end;k++){
             int cnt=0;
             long max=Math.max(left,k);
             for (long i=max;i<=right;i++){
                 if (i%k==0) {
                     cnt += 1;
                     if (i / k > end) {
                         t = getFirst(i / k);
                         res[t] += 1;
                     }
                 }
             }
             t=getFirst(k);
             res[t]+=cnt;
         }
         for (t=1;t<res.length;t++)
             System.out.println(res[t]);
        }
    }
    private static int getFirst(long k){
        long res=0;
        while (k!=0){
            res=k;
            k/=10;
        }
        return (int)res;
    }
    private static int getFirst1(int k){
        //System.out.println(k);
        String str= String.valueOf(k);
        return str.charAt(0)-'0';
    }
}
