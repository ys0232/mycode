package Implementation;
import java.util.*;
public class BetweenTwoSet {

	private static int gcd(int a,int b){
		//辗转相除法求最大公约数
		int gcd=1;
		int n=a>b?a:b;
		int m=a<b?a:b;
		int t;
		while(m>0){
			t=n%m;
			n=m;
			m=t;
		}
		gcd=n;
		return gcd;
	} 
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[] a=new int[m];
		for(int i=0;i<m;i++)
			a[i]=sc.nextInt();
		int[] b=new int[n];
		for(int i=0;i<n;i++)
			b[i]=sc.nextInt();
		sc.close();
		int t=b[0];
		if(n>1){
			t=gcd(b[0],b[1]);
			 }
			if(n>2)
			for(int i=2;i<n;i++){
				t=gcd(t,b[i]);
			}
			int gcdB=t;
			int count=0;
		Arrays.sort(a);
		boolean flag=true;
		int min=1;
		int k=0;
		while(k<=n){
			if(min<b[k]/gcdB)
				min=b[k]/gcdB;
			k++;
		}
		int max=a[m-1];
		for(int i=gcdB;i>=max;i=i/min){
			flag=true;
			for(int j=0;j<m;j++){
				if(i%a[j]!=0){
					flag=false;
					break;
				}
			}
			if(flag)
				count++;
		}
		System.out.println(count);
	}
}
