package ThirdDaysTest;
import java.util.*;

interface AdvancedArithmetic{
	int divisorSum(int n);
}
class calculator implements AdvancedArithmetic{

	@Override
	public int divisorSum(int n) {
		// TODO Auto-generated method stub
		int sum=1;
		for(int i=2;i<=n;i++)
			if(n%i==0)
				sum+=i;
		return sum;
	}
	
}
public class day19 {
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	sc.close();
	AdvancedArithmetic mycalcul=new calculator();
	int sum=mycalcul.divisorSum(n);
	System.out.println(sum);
}
}
