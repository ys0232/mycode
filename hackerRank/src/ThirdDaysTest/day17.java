package ThirdDaysTest;


import java.util.*;
import java.io.*;
class CalculatorTest{
	int power(int p,int n) throws Exception{
		int np=1;
		if(n<0 || p<0){
			throw new Exception("n and p should be non-negative");
		}
		else
		{
			for(int i=1;i<=n;i++){
				np=np*p;
			}
		}
		return np;
	}
	}
public class day17 {

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int p=in.nextInt();
		CalculatorTest cs=new CalculatorTest();
		try{
			int ans=cs.power(n, p);
			System.out.println(ans);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
