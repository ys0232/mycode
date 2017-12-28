package Implementation;
import java.util.*;
public class savethePrisoner {

	public static void main(){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			int s=sc.nextInt();
			while(m-->0){
				s++;
				if(s>n)
					s=s%n;
			}
			System.out.println(s);
		}
		sc.close();
	}

}
