package ACMTest;
import java.util.*;

public class t1005 {
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		long n=sc.nextInt();
		while(a!=0 &&b!=0 &&n!=0){
			int f1,f2,fn = 0;
			f1=1;f2=1;
			n=n%50;
			if(n==0 || n==1)
				System.out.println(1);
			else
			{
			for(int i=3;i<=n;i++){
				fn=(a*f2+b*f1)%7;
				f1=f2;
				f2=fn;
				}
			System.out.println(fn+"\n");
			
			a=sc.nextInt();
			b=sc.nextInt();
			n=sc.nextInt();
		}
			}
		sc.close();
		
	}
}
