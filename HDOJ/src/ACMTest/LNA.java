package ACMTest;
import java.util.*;
public class LNA {
	public static int max(int a,int b){
		return a>b?a:b;
	}
	public static int  min(int a,int b){
		return a<b?a:b;
	}
	
	public static void main(String[] args){
		int[] a={3,4,12,232,45,657,87,1,2,132,19};
		int len=a.length;
		int[][] c=new int[len+1][len+1];
		int[][] b=new int[len+1][len+1];
		
		for(int i=0;i<=len;i++){
			//±ß½çÖÃÎª0
			c[i][0]=0;
			c[0][i]=0;
			b[i][0]=1;
			b[0][i]=2;
			}
		for(int i=1;i<=len;i++){
			for(int j=1;j<=len;j++){
				if(a[i-1]<a[j-1]){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=0;
				}
				else{
					if(c[i-1][j]>c[i][j-1]){
						c[i][j]=c[i-1][j];
						b[i][j]=1;
						}
					else
					{
						c[i][j]=c[i][j-1];
						b[i][j]=2;
					}
				}
			}
		}
		int n=len;
		int m=n;
		int mLen=c[len][len];
		int tmp=a[len-1];
		int k=0;
		int[] as=new int[mLen+1];
		int i=len;
		int j=len;
		while(n!=0 ||m!=0){
			switch(b[n][m]){
			case 0:as[k++]=a[n-1];n--;m--;break;
			case 1:n--;break;
			case 2:m--;break;
			}
		}
		
		
			
				
		
		System.out.println(c[len][len]);
		System.out.println(Arrays.toString(as));
		System.out.println();
		System.out.println(Arrays.toString(a));
		for(int p=0;p<=len;p++)
		System.out.println(Arrays.toString(c[p]));
		System.out.println();
		for(int p=0;p<=len;p++)
			System.out.println(Arrays.toString(b[p]));
	}

}
