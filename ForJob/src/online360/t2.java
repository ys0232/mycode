package online360;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int t=sc.nextInt();
            while (t-->0){
                long r = sc.nextLong();
                long g = sc.nextLong();
                long b = sc.nextLong();
                if (r<g){
                    long kt=r;r=g;g=kt;
                }
                if (r<b){
                    long kt=r;r=b;b=kt;
                }
                if (g<b){
                    long kt=b;b=g;g=kt;
                }
                //r>g>b
                long res=b+Math.min((r-b)/2,g-b);
                long temp=r-2*b;
                if (temp>g){
                    temp/=2;
                }else g/=2;
                long tem=b;
                if (temp+g>=3){
                    tem+=Math.min(temp,g);
                }
                res=res>temp?res:tem;
                System.out.println(res);
            }

        }
    }
}
