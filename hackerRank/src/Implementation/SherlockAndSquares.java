package Implementation;
import java.util.*;

public class SherlockAndSquares {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int count=0;
			int sq=(int)Math.sqrt(a);
			if(sq*sq==a)
				count++;
			sq++;
			while(sq*sq<=b){
				sq++;
				count++;
			}
			
			System.out.println(count);
		}
	}	
}
