package wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class clock{
    int a,b;

    public clock(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class wakeupClock {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            clock[] clocks=new clock[n];
            for (int i=0;i<n;i++){
                int a=sc.nextInt();int b=sc.nextInt();
                clocks[i]=new clock(a,b);
            }
            int x=sc.nextInt();
            int a=sc.nextInt();int b=sc.nextInt();
            int min=0;
            if (b-x<0){
                min=b-x+60;
                a-=1;
            }else min=b-x;
            Arrays.sort(clocks, new Comparator<clock>() {
                @Override
                public int compare(clock clock, clock t1) {
                    return t1.a-clock.a!=0?t1.a-clock.a:t1.b-clock.b;
                }
            });
            for (int i=0;i<n;i++){
               System.out.println(clocks[i].a+"###\t###"+clocks[i].b);
            }
            System.out.println(a+"\t"+min);
            for (int i=0;i<n;i++){
                if (a==clocks[i].a && min>=clocks[i].b ||(a>clocks[i].a)){
                    System.out.println(clocks[i].a+"  "+clocks[i].b);
                    break;
                }
            }

        }
    }
}
