package ThirdDaysTest;
import java.util.*;
public class day27 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int num=sc.nextInt();
		int limit=sc.nextInt();
		int k=0;
		for(int i=0;i<num;i++){
			int stu=sc.nextInt();
			if(stu<=0)
				k++;
				
		}
		if(k>=limit){
			System.out.println("YES");
		}
		else
			System.out.println("NO");
	}
		}
}
