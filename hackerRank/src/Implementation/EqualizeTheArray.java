package Implementation;
import java.util.*;

public class EqualizeTheArray {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		sc.close();
		Arrays.sort(a);
		int count=0;
		int tmp=1;
		for(int i=0;i<n-1;i++){
			if(a[i]==a[i+1]){
				tmp++;
			}
			else{
				tmp=1;
			}
			if(tmp>count){
				count=tmp;
			}
				
		}
		System.out.println(n-count);
	}
}
