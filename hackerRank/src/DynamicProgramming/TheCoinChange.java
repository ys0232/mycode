package DynamicProgramming;
import java.util.*;
public class TheCoinChange {
	private static long CoinChangeCount(int n,int[] a){
		long count=0;
		int len=a.length+1;
		int[][] c=new int[len][len];
		for(int i=0;i<len;i++) c[i+1][0]=a[i];
		for(int i=0;i<len;i++) c[0][i+1]=a[i];
		
		for(int i=1;i<len;i++){
			for(int j=i;j<len;j++){
				c[i][j]=Math.min(c[i-1][j-1],c[i-1][j]);
				if(c[i][j]==n)
					count++;}
		}
		return count;
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] a=new int[m];
		for(int i=0;i<m;i++){
			a[i]=sc.nextInt();
		}
		sc.close();
		long count=0;
		Arrays.sort(a);
		count=CoinChangeCount(n,a);
		for(int i=1;i<m;i++){
			count+=CoinChangeCount(a[i],a);
		}
		System.out.println(count);
	}
}
