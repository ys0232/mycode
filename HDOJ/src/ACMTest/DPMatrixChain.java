package ACMTest;
import java.util.*;

public class DPMatrixChain {
public static int MAX=65535;
public static void printParent(int[][] s,int i,int j){
	
	if(i==j)
		System.out.print("A"+i);
	else{
		System.out.print("(");
		 printParent(s,i,s[i][j]);
		 printParent(s,s[i][j]+1,j);
		 System.out.print(")");
	}
}
	public static void main(String[] args){
		//Scanner sc=new Scanner(System.in);
		//int n=sc.nextInt();
		int n=6;
		int[] p=new int[n+1];//p[0]is the count of A0's rows,p[i] is the count of Ai's columns
		int[][] m=new int[n][n];
		int[][] s=new int[n][n];
		/*for(int i=0;i<=n;i++){
			p[i]=sc.nextInt();
		}*/
		p[0]=30;p[1]=35;p[2]=15;
		p[3]=5;p[4]=10;p[5]=20;p[6]=25;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			m[i][j]=0;
		for(int c=2;c<n;c++){
			System.out.println(c);
			for(int i=0;i<n-c;i++){
				int j=i+c-1;
				m[i][j]=MAX;
				for(int k=i;k<j;k++){
					int q=m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
					if(q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(Arrays.toString(s[i]));
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.println(Arrays.toString(m[i]));
		}
		printParent(s,1,n-1);
	}
}
