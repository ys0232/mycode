package wangyi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InterstellarCross {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            long h=sc.nextLong();
            double res=0;
            res=Math.sqrt(h+0.25)-0.5;
            String s=String.valueOf(res);
            res=Integer.valueOf(s.split("\\.")[0]);
            int pos=0;
            try{
                pos=Integer.valueOf(s.split("E")[1]);
                res=0;int i=0;
                for ( i=0;i<=pos+1 && s.charAt(i)!='E';i++){
                    if (s.charAt(i)!='.')
                    res=res*10+s.charAt(i)-'0';
                }
                if (i<=pos+1){
                    res*=Math.pow(10,pos-i);
                }
            }catch (Exception e){

            }
            DecimalFormat df=new DecimalFormat("#0");
            System.out.println(df.format(res)+"\t"+s);
        }
    }
}
