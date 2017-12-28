package ACMTest;
import java.util.*;
public class t1003ByMyself {
	public static void main(String[] args){

		int num=0;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		int k=1;
		long max=0;
		while(k<=num){
			int len=0;
			len=sc.nextInt();
			int[] a=new int[len];
			for(int i=0;i<len;i++)
				a[i]=sc.nextInt();
		int start=1;
		int end=1;
		long sum=0;
		max=-1001;
		int startTmp=1;
		for(int i=0;i<len;i++){
		         sum+=a[i];
			if(sum>max){
				max=sum;
				start=startTmp;
				end=i+1;
			}
			if(sum<0){
				sum=0;
				startTmp=i+2;
				
			}	
			
		}
		System.out.println("Case "+k+":");
		System.out.println(max+" "+start+" "+end);
		if(k<num)
			System.out.println();
		k++;
		}
		sc.close();

	}
	}
