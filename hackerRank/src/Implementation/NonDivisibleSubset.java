package Implementation;
import java.util.*;

public class NonDivisibleSubset {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sc.close();
		int sq=(int) Math.sqrt(k); 
		int j;
		for(j=2;j<=sq;j++){
			if(k%j==0)
				break;
		}
		int maxCount=0;
		int[] yinsu=new int[k];
		int m=0;
		int[] re=new int[k];
		if(j<sq || sq*sq==k){
			if(k==1)
				maxCount=0;
			else{
				for(int i=0;i<n;i++){
					int tmp=a[i]%k;
					re[tmp]++;
				}
				
				for(int i=2;i<k;i++){
					if(k%i==0){
						yinsu[m++]=i;
						re[i]=k/i-1;
					}
				}
				for(int i=0;i<k;i++){
					
				}
			
				
			}
			
		}
		else{
			if(k!=2){
			for(int i=0;i<n;i++){
				int tmp=a[i]%k;
				if(re[tmp]<k-1)
				re[tmp]++;
			}
			for(int i=1;i<k;i++){
				
			}
			
			for(int i=1;i<=k/2;i++){
				if(re[k-i]<re[i]&&re[i]<k)
					maxCount+=re[i];
				else
					if(re[k-i]>re[i] && re[k-i]<k)
						maxCount+=re[k-i];
					else
						maxCount+=k-1;
						
			}}
			}
			if(k==2)
				maxCount=1;
			
	}
}
