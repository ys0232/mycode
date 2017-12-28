package Implementation;
import java.util.*;

public class BeautifulTriplets {

	public static int beautiful(int[] a,int q, int d){
		int num=0;
		int tmp=a[q];
		for(int i=q+1;i<a.length;i++){
			if(a[i]-tmp==d)
			num=i;
		}
		return num;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sc.close();
		int count=0;
		for(int i=0;i<n;i++){
			int num1=beautiful(a,i,d);
			if(num1!=0){
				num1=beautiful(a,num1,d);
				if(num1!=0)
				count++;
			}
		}
		
		System.out.println(count);
	}
}
