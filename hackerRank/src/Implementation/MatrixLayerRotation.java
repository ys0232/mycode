package Implementation;
import java.util.*;
public class MatrixLayerRotation {
	private static void MatrixRotation(int[][] a,int k,int r){
		int m=a.length;
		int n=a[0].length;
		int len=2*(m-2*k)+(n-2-2*k)*2;
		int[] tmp=new int[len];
		int p=k;int q=k+1;
		int len1=m+n-4*k-1;
		for(int i=0;i<len1-1;i++){
			if(p<n-k)
			tmp[i]=a[k][p++];
			else
				tmp[i]=a[q++][p-1];
		}
		p=p-1;
		for(int i=0;i<len-len1+1;i++){
		
			if(p>k)
				tmp[i+len1-1]=a[q][p--];
			else
				tmp[i+len1-1]=a[q--][p];
		}
		
		int[] t=new int[len];
		r=r%len;
			for(int i=0;i<r;i++)
				t[len-r+i]=tmp[i];
			for(int i=0;i<len-r;i++)
				t[i]=tmp[r+i];
			p=0;
	for(int i=k;i<n-k;i++)
		a[k][i]=t[p++];
	for(int i=k+1;i<m-k;i++)
		a[i][n-k-1]=t[p++];
	
	for(int i=n-k-2;i>k;i--)
		a[m-k-1][i]=t[p++];
	
	for(int i=m-k-1;i>k+1;i--)
		a[i][k]=t[p++];
	a[k+1][k]=t[p];	
	
		System.out.println(k+1+"\n"+Arrays.toString(tmp)+"\n"+Arrays.toString(t));
	}
	
	private static int min(int a,int b){
		return a<b?a:b;
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int  m=sc.nextInt();
		int n=sc.nextInt();
		int r=sc.nextInt();
		int[][] a=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		}
		sc.close();
		int layer=min(m,n)/2;
		for(int k=0;k<layer;k++)
			MatrixRotation(a,k,r);
		for(int i=0;i<m;i++)
		System.out.println(Arrays.toString(a[i]));
	}
}
