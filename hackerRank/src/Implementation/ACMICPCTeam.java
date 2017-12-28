package Implementation;
import java.util.*;

public class ACMICPCTeam {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		String topic[]=new String[n];
		for(int i=0;i<n;i++){
			topic[i]=sc.next();
		}
		int count=0;
		int max=0;
		int len=n*(n+1)/2;
		int[] sum=new int[len];
		int q=0;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				int s,t,k=0;
				for(int p=0;p<m;p++){
					s=topic[i].charAt(p)-'0';
					t=topic[j].charAt(p)-'0';
					if(s==1|| t==1)
						k++;
				}
				sum[q++]=k;
				}}
		Arrays.sort(sum);
		max=sum[len-1];
		while(sum[len-count-1]==sum[len-2-count])count++;
				
		System.out.println(max+"\n"+(1+count));
	}

}
