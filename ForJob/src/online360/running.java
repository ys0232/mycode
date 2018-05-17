package online360;


import java.util.Scanner;

public class running {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
           double l=sc.nextDouble();
            double r=sc.nextDouble();
            double x=r* Math.cos(l/r);
            double y=r* Math.sin(l/r);
            //System.out.println(x+" "+y+"\n"+x+" "+(-y));
            System.out.println(String.format("%.3f %.3f\n%.3f %.3f",x,-y,x,y));
        }
    }
}
