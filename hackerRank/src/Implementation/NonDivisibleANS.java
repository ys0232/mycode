package Implementation;
import java.util.*;

public class NonDivisibleANS {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sc.close();
		int[] r=new int[k];
		for(int i=0;i<n;i++){
			r[a[i]%k]+=1;
		}
		int res=0;
		for(int i=0;i<k/2+1;i++){
			if(i==0 || k==i*2){
				res+=(r[i]!=0)?1:0;
			}
			else{
				res+=Math.max(r[i], r[k-i]);}
		}
		System.out.println(res);
	}
}
