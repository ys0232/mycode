package Implementation;
import java.util.*;

public class FindDigits {

	public static void main(){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int tmp=n;
			int count=0;
			while(tmp!=0){
				if(tmp%10!=0)
				if(n%(tmp%10)==0)
					count++;
				tmp/=10;
			}
			System.out.println(count);
		}
		sc.close();
	}
}
