package ThirdDaysTest;
import java.util.*;
public class day29 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		while(num-->0){
			int N=sc.nextInt();
			int K=sc.nextInt();
			int max=0;
			int tmp=0;
			for(int i=1;i<N;i++){
				for(int j=i+1;j<=N;j++){
				tmp=i&j;
				if(tmp>max && tmp<K){
				max=tmp;
				}
				}
			}
			System.out.println(max);
		}
		sc.close();
	}
}
