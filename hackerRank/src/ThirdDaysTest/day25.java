package ThirdDaysTest;
import java.util.*;
import java.math.*;
public class day25 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n-->0){
			int num=sc.nextInt();
			int i;
			for(i=2;i<=Math.sqrt(num);i++){
				if(num%i==0){
					
					break;
				}
					
			}
			if(i>Math.sqrt(num)&&num!=1)
				System.out.println("prime");
			else
				System.out.println("Not prime");
		}
		
	}
}
