package tenDaysOfStatistics;
import java.util.*;

public class day1Interquartile {

	private static float median(int[] a,int start,int length){
		float m=0.0f;
		if(length%2==0){
			int half_len=length/2;
			m=(float) ((float)(a[start+half_len]+a[start+half_len-1])/2.0);
		}
		else
			m=a[start+length/2];
		
		return m;
		
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int[] f=new int[n];
		int len=0; 
		for(int i=0;i<n;i++){
			f[i]=sc.nextInt();
		    len+=f[i];
		}
		sc.close();
		int[] arr=new int[len];
		int m=0;
		for(int i=0;i<len;){
			int k=0;
			while(k++<f[m])
			arr[i++]=a[m];
			m++;
					}
		Arrays.sort(arr);
		float q1=median(arr,0,len/2);
		float q3=median(arr,len/2,len/2);
		//System.out.println(Arrays.toString(arr));
		System.out.println(q3-q1);
	}
}
