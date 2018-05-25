package CodeM;

import java.util.Scanner;

public class PhysicalTraining_2017A {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double v=sc.nextDouble();
        double u=sc.nextDouble();
        double[] c=new double[n];
        double[] d=new double[n];
        for (int i=0;i<n;i++){
            c[i]=sc.nextDouble();
        }
        for (int i=0;i<n;i++){
            d[i]=sc.nextDouble();
        }
        double res=0;
        for (int j=0;j<n;j++){
            for (int i=0;i<n;i++){
                res+=u/(c[i]-j*d[i]-v);
            }
        }
        System.out.println(String.format("%.3f",res));
    }
}
