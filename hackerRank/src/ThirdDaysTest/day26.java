package ThirdDaysTest;
import java.util.*;
public class day26 {

	public static void main(String[] args){

		int fina=0;
		String s1="962015";
		String s2="662015";
		int d1=s1.charAt(0);
		int m1=s1.charAt(1);
		int y1=2015;
		int d2=s2.charAt(0);
		int m2=s2.charAt(1);
		int y2=2015;
		if(y1>y2)
			fina=10000;
		else{
			if(y1==y2 && m1>m2){
				fina=500*(m1-m2);
				
			}
			else{
				if(y1==y2 && m1==m2 && d1>d2){
					fina=15*(d1-d2);
				}
				else{
					fina=0;
				}
			}
		}
	System.out.println(fina);
	
	}}
