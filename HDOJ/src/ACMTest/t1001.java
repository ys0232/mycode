package ACMTest;
import java.util.*;
import java.io.*;
public class t1001 {
public static void main(String[] args){
	long sum;
	long n;
	Scanner sc=new Scanner(System.in);
	while(sc.hasNext()){
		sum=0;
		n=sc.nextLong();
		for(int i=1;i<=n;i++){
			sum=sum+i;
		}
		System.out.println(sum);
		System.out.println("");
	}
	
}
}
