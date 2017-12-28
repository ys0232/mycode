package sixth;
import java.util.*;
import java.math.*;
public class sixTest {

	
	public static int DPMatrixChain(int[][] m,int[] p){
		int n=p.length;
		int finalI=0;
		int finalJ=0;
		 for (int len = 2; len < n; len++)
	        {
	            for (int i = 1; i < n - len + 1; ++i)
	            {
	                int j = i + len - 1;
	                m[i][j] = Integer.MAX_VALUE;
	                for (int k = i; k <j; ++k)
	                {
	                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
	                    if (q < m[i][j])
	                    {
	                        m[i][j] = q;
	                        finalI=i;
	                        finalJ=j;
	         
	                    }
	                }
	            }
	        }
		 for(int i=0;i<n;i++)
		 System.out.println(Arrays.toString(m[i]));
		 return m[finalI][finalJ];
	}
	public static int recursiveMatrixChain(int[] p,int i,int j){
		//recursiveMatrixChain
		int n=p.length;
		int[][] m=new int[n][n];
		if(i==j)
			return 0;
		m[i][j]=Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			int q=recursiveMatrixChain(p,i,k)+recursiveMatrixChain(p,k+1,j)+p[i-1]*p[k]*p[j];
			if(q<m[i][j])
				m[i][j]=q;
			
		}
		return m[i][j];
		
	}
	
	public static int lookUpChain(int[][] m,int[] p,int i,int j){
		if(m[i][j]<Integer.MAX_VALUE)
			//
			return m[i][j];
		if(i==j)
			m[i][j]=0;
		for(int k=i;k<j;k++){
			int q=lookUpChain(m,p,i,k)+lookUpChain(m,p,k+1,j)+p[i-1]*p[k]*p[j];
			if(q<m[i][j])
				m[i][j]=q;
		}
		return m[i][j];
	}
	
	
	public static int[][] initialMemo(int[][] m,int n){
		//
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				m[i][j]=Integer.MAX_VALUE;
			}
		}
		return m;
		
	}
	public static int[][] initialDP(int[][] m,int n){
		for(int i=0;i<n;i++){
			m[i][i]=0;
		}
		return m;
	}
	

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int MaxLen=sc.nextInt();
		
		int[] p=new int[n];
		for(int i=0;i<n;i++){
			p[i]=(int)(Math.random()*MaxLen);
		}
		System.out.println(Arrays.toString(p));
		int[][] m=new int[n][n];
		
		
		long startTime=System.nanoTime(); 
		System.out.println("递归方法求解结果："+recursiveMatrixChain(p,1,6));
		long endTime=System.nanoTime(); 
		System.out.println("递归方法的运行时间："+(endTime-startTime));
		
		
		startTime=System.currentTimeMillis();
		m=initialDP(m,n);
		System.out.println("动态规划方法求解结果："+DPMatrixChain(m,p));
		endTime=System.currentTimeMillis(); 
		System.out.println("动态规划方法的运行时间："+(endTime-startTime));
		
		startTime=System.currentTimeMillis();
		m=initialMemo(m,n);
		System.out.println("带备忘录的递归方法求解结果："+lookUpChain(m,p,1,6));
		endTime=System.currentTimeMillis(); 
		System.out.println("带备忘录的递归方法的运行时间："+(endTime-startTime));
		
	}
	
}
