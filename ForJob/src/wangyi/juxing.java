package wangyi;

import java.util.Scanner;

public class juxing {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] a=new int[4][n];
            int[] x=new int[2*n];
            int[] y=new int[2*n];
            int xk=0,yk=0;
            for (int i=0;i<n;i++){
                a[0][i]=sc.nextInt();
               x[xk++]=a[0][i];
            }
            for (int i=0;i<n;i++){
                a[1][i]=sc.nextInt();
               y[yk++]=a[1][i];
            }
            for (int i=0;i<n;i++){
                a[2][i]=sc.nextInt();
                x[xk++]=a[2][i];
            }
            for (int i=0;i<n;i++){
                a[3][i]=sc.nextInt();
                y[yk++]=a[3][i];
            }
            int res=1;
            for (int i=0;i<2*n;i++){
                for (int j=0;j<2*n;j++){
                    int count=0;
                    for (int k=0;k<n;k++){
                        if (a[0][k]<x[i]&&a[1][k]<y[j] && a[2][k]>=x[i]&&a[3][k]>=y[j]){
                            count++;
                        }
                       /* System.out.println(a[0][k]+"**\t**"+a[1][k]+"\t"+a[2][k]+"\t"+a[3][k]+"\n"+
                        i+"==\t=="+j+"\t"+count);*/
                    }
                    res=count>res?count:res;
                    if (res==n)break;
                }
                if (res==n)break;
            }
            System.out.println(res);
        }
    }
}
