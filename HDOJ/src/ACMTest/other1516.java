package ACMTest;
import java.util.*;
import java.io.*;
public class other1516 {

	public static int Min(int a,int b){
		return a<b?a:b;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s1,s2;
		int MAX=81;
		while(sc.hasNext()){
		s1=sc.nextLine();
		s2=sc.nextLine();
		char[] ch1,ch2;
		ch1=s1.toCharArray();
		ch2=s2.toCharArray();
		int len1,len2;
		len1=s1.length();
		len2=s2.length();
		int[][] dp=new int[MAX][MAX];
		int[][] to=new int[MAX][MAX];
		for(int i=1;i<=len1;i++){
			dp[i][0]=dp[i-1][0]+1;
		    to[i][0]=1;
		}
		for(int j=1;j<=len2;j++){
			dp[0][j]=dp[0][j-1]+1;
		    to[0][j]=2;
		}
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(ch1[i-1]==ch2[j-1]){
					dp[i][j]=dp[i-1][j-1];
					to[i][j]=0;
				}
				else{
					dp[i][j]=Min(Min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j])+1;
					if(dp[i][j]==dp[i-1][j]+1)
						to[i][j]=1;
					if(dp[i][j]==dp[i][j-1]+1)
						to[i][j]=2;
					if(dp[i][j]==dp[i-1][j-1]+1)
						to[i][j]=3;
					
				}
			}
		}
		System.out.println(dp[len1][len2]);		
		int p=0;
		int n=len1;
		int m=len2;
		while(n!=0||m!=0){
			switch(to[n][m]){
			case 0:n--;m--;break;
			case 1:System.out.println(++p+" Delete "+n);n--;break;
			case 2:System.out.println(++p+" Insert "+(n+1)+","+ch2[m-1]);m--;break;
			case 3:System.out.println(++p+" Replace "+n+","+ch2[m-1]);n--;m--;break;
			}
			
			
		}
		
	}
}
}