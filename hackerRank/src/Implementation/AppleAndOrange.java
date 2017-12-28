package Implementation;
import java.util.*;

public class AppleAndOrange {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int t=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[] apple=new int[m];
		int[] orange=new int[n];
		int appleCount=0;
		int orangeCount=0;
	
		for(int i=0;i<m;i++){
			int tmp=0;
			apple[i]=sc.nextInt();
			 tmp=apple[i]+a;
		if(tmp>=s &&tmp<=t)
			appleCount++;
			
		}
		for(int i=0;i<n;i++){
			int tmp=0;
			orange[i]=sc.nextInt();
			tmp=orange[i]+b;
			if(tmp>=s && tmp<=t)
				orangeCount++;
			}
		sc.close();
		System.out.println(appleCount+"\n"+orangeCount);
		
	}
}
