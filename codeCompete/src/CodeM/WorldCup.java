package CodeM;

import java.util.Arrays;
import java.util.Scanner;

public class WorldCup {
    // It's completely a probability problem
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=16;
        double[][] pro=new double[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                pro[i][j]=sc.nextDouble();
        }
        double[][] res=new double[4][n];
        for (int i=0;i<n;i++){
            // race 1/8
            if (i%2==0)
                res[0][i]=pro[i][i+1];
            else res[0][i]=pro[i][i-1];
        }
        //System.out.println("1/8 race :"+Arrays.toString(res[0]));
        for (int i=0;i<n;i+=2){
            // race 1/4
            if (i%4==0){
            res[1][i]=res[0][i]*(res[0][i+2]*pro[i][i+2]
                    +res[0][i+3]*pro[i][i+3]);
            res[1][i+1]=res[0][i+1]*(res[0][i+2]*pro[i+1][i+2]
                        +res[0][i+3]*pro[i+1][i+3]);
            }else {
                res[1][i]=res[0][i]*(res[0][i-2]*pro[i][i-2]
                        +res[0][i-1]*pro[i][i-1]);
                res[1][i+1]=res[0][i+1]*(res[0][i-2]*pro[i+1][i-2]
                        +res[0][i-1]*pro[i+1][i-1]);
            }
        }
       // System.out.println("1/4 race :"+Arrays.toString(res[1]));

        for (int i=0;i<n;i+=4){
            // race 1/2
            if (i%8==0){
            for (int j=0;j<4;j++){
                res[2][i+j]=res[1][i+j]*(res[1][i+4]*pro[i+j][i+4]
                        +res[1][i+5]*pro[i+j][i+5]+res[1][i+6]*pro[i+j][i+6]
                        +res[1][i+7]*pro[i+j][i+7]);
            }}else {
                for (int j=0;j<4;j++){
                    res[2][i+j]=res[1][i+j]*(res[1][i-4]*pro[i+j][i-4]
                            +res[1][i-3]*pro[i+j][i-3]+res[1][i-2]*pro[i+j][i-2]
                            +res[1][i-1]*pro[i+j][i-1]);
                }
            }
        }
            //final race
        for (int j=0;j<8;j++){
            double tem=0;
            for (int k=8;k<16;k++){
                tem+=(res[2][k]*pro[j][k]);
            }
            res[3][j]=res[2][j]*tem;
        }
        for (int j=8;j<16;j++){
            double tem=0;
            for (int k=0;k<8;k++){
                tem+=(res[2][k]*pro[j][k]);
            }
            res[3][j]=res[2][j]*tem;
        }
        //System.out.println("==========\n"+Arrays.toString(res[3]));
        for (int i=0;i<n-1;i++)
            System.out.print(String.format("%.10f",res[3][i])+" ");
        System.out.println(String.format("%.10f",res[3][n-1]));

    }
}
