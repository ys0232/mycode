package ACMTest;

import java.util.Scanner;

public class Main {  
	  
    public static void main(String[] args) {  
        Scanner sc =new Scanner(System.in);  
        int T,N,num,startP=1,endP=1;  
        T=sc.nextInt();  
        int m=T;  
        while (T-->0){  
            int max=-1001,temp=1,sum=0;  
            N=sc.nextInt();  
            for(int i=1;i<=N;i++){  
                num=sc.nextInt();  
                sum+=num;  
                if(sum>max){  
                    max=sum;  
                    startP=temp;  
                    endP=i;  
                }  
                if(sum<0){  
                    sum=0;  
                    temp=i+1;  
                }  
            }  
            System.out.println("Case "+(m-T)+":");  
            System.out.println(max+" "+startP+" "+endP);  
            if(T!=0){  
                System.out.println("");  
            }  
        }  
    }  
}  